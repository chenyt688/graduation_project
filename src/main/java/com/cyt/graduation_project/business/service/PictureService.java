package com.cyt.graduation_project.business.service;

import com.cyt.graduation_project.business.dao.PictureDao;
import com.cyt.graduation_project.business.entry.relation.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public Object uploadPicture(Picture picture){

        return pictureDao.addPicture(picture);

    }

    public ArrayList<Picture> queryAllPicture(){
        return pictureDao.queryAllPicture();
    }

    public int queryPictureByImage(Picture picture){
        return pictureDao.queryPictureByImage(picture);
    }
}
