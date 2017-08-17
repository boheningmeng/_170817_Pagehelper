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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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


}
