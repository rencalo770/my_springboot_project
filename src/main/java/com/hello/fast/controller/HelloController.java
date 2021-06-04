/*
package com.hello.fast.controller;

import com.hello.fast.DO.Adder;
import com.hello.fast.DO.Blog;
import com.hello.fast.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author renyunyi
 *//*


@RestController
public class HelloController {


    private Adder adder;

    @Autowired
    public void setAdder(Adder adder) {
        this.adder = adder;
    }


    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }


    @RequestMapping(path = "/path/{i}")
    public int getInt(@PathVariable("i") int i){
        adder.x += i;
        return adder.x;
    }


    @RequestMapping(path = "/get/{id}")
    public String getBlogContent(@PathVariable("id") int id){
        Blog blog = blogService.getBlog(id);
        return blog.txt;
    }

    @RequestMapping(path = "/1")
    @ResponseBody
    public Blog getHello(Blog blog){
        return blog;
    }

    @RequestMapping(path = "/hello")
    public String get(){
        return "world";
    }

}
*/
