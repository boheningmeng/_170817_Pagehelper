package cn.lh.controller;

import cn.lh.mapper.CategoryMapper;
import cn.lh.pojo.Category;
import cn.lh.pojo.CategoryExample;
import cn.lh.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

   /* @RequestMapping("/listCategory")
    public ModelAndView listCategory() {
        ModelAndView mav = new ModelAndView();
        List<Category> cs = categoryService.list();
        mav.addObject("cs", cs);
        mav.setViewName("/WEB-INF/jsp/list.jsp");
        return mav;
    }*/

    @RequestMapping("/showCategory")
    public ModelAndView showCategory( @RequestParam(required=true,defaultValue="1") Integer page,
                                @RequestParam(required=false,defaultValue="10") Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Category> list = categoryMapper.selectByExample(new CategoryExample());
        PageInfo<Category> pageInfo = new PageInfo<Category>(list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cs",list);
        modelAndView.addObject("page",pageInfo);
        modelAndView.setViewName("/WEB-INF/jsp/list.jsp");
        return modelAndView;
    }
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        try {
            System.out.println(dir);
            file.transferTo(dir);
        }catch(Exception e){
            return "failure.jsp";
        }
        return "success.jsp";
    }


}
