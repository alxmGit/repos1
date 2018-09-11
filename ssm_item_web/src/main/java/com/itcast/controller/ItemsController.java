package com.itcast.controller;

import com.itcast.domain.Items;
import com.itcast.servcie.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Items> itemsList = itemsService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("itemsList", itemsList);
        mv.setViewName("itemsList");
      return  mv;
    }

    /**
     * g根据id修改信息
     * @param id
     * @return
     */
    @RequestMapping("/editItems")
    public  ModelAndView addItems(Integer id){

        Items items = itemsService.findById(id);

    ModelAndView mv = new ModelAndView();
        mv.addObject("items", items);
    mv.setViewName("editItems");
    return mv;

    }

    /**
     * 修改信息
     */

    @RequestMapping("/updateItems")
    public String update(Items items , HttpServletRequest request, MultipartFile upload) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        System.out.println(path);
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename= uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        itemsService.update(items);
        System.out.println("文件上传");

        return "redirect:findAll";
    }
}
