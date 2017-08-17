package cn.lh.service.Impl;

import cn.lh.mapper.CategoryMapper;
import cn.lh.pojo.Category;
import cn.lh.pojo.CategoryExample;
import cn.lh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LENOVO on 2017/8/17.
 */
@Service("category")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        CategoryExample categoryExample = new CategoryExample();
        return categoryMapper.selectByExample(categoryExample);
    }
}
