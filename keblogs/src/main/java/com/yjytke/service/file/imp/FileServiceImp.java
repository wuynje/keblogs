package com.yjytke.service.file.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjytke.dao.FileDao;
import com.yjytke.entity.KeFile;
import com.yjytke.service.file.FileService;

/**
 * @author wuynje
 * @time 2018年8月30日 下午8:01:43
 * @version 1.0
 * @description:
 */
@Service
public class FileServiceImp implements FileService {

	@Autowired
	private FileDao fileDao;
	
	@Override
	public void markEditorImgUpload(KeFile file) {
		fileDao.addFile(file);
	}
}
