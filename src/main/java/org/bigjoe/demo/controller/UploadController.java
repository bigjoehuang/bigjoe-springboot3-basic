package org.bigjoe.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@PostMapping("/doupload")
	public String doupload(HttpServletRequest req, MultipartFile uploadFile) {
		/*
		 * <form action="/upload" method="post" enctype="multipart/form-data"> <p><input
		 * type="file" name="uploadFile" value="选一张图片"></p> <p><input type="submit"
		 * value="开始上传"></p> </form>
		 */
		if (uploadFile == null) {
			return "null";
		}

		String path = req.getSession().getServletContext().getRealPath("/upload/");
		File folder = new File(path);

		if (!folder.isDirectory()) {
			folder.mkdirs();
		}

		String oName = uploadFile.getOriginalFilename();
		String nName = UUID.randomUUID().toString() + oName.substring(oName.lastIndexOf("."), oName.length());

		try {
			uploadFile.transferTo(new File(folder + File.separator + nName));

			String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload/"
					+ nName;

			return filePath;

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return "error";
	}

	@PostMapping("/uploadFiles")
	public String uploadFiles(HttpServletRequest req, MultipartFile[] uploadFiles) {
		/*
		 * <form action="/uploadFiles" method="post" enctype="multipart/form-data">
		 * <p>选第一张图片：<input type="file" name="uploadFiles"></p> <p>选第二张图片：<input
		 * type="file" name="uploadFiles"></p> <p>选第三张图片：<input type="file"
		 * name="uploadFiles"></p> <p><input type="submit" value="开始上传"></p> </form>
		 * </body>
		 */

		String path = req.getSession().getServletContext().getRealPath("/upload/");
		File folder = new File(path);

		if (!folder.isDirectory()) {
			folder.mkdirs();
		}

		if (null != uploadFiles && uploadFiles.length > 0) {

			for (MultipartFile uploadFile : uploadFiles) {

				String oName = uploadFile.getOriginalFilename();
				String nName = UUID.randomUUID().toString() + oName.substring(oName.lastIndexOf("."), oName.length());

				try {

					uploadFile.transferTo(new File(folder, nName));
					return "ok";

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		return "error";
	}
}
