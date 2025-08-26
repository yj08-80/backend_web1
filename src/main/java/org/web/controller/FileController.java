package org.web.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.web.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController { // class start
    @Autowired // 스프링 컨테이너에서 빈 꺼내오기
    private FileService fileService;

    // [1] 업로드
    //
    @PostMapping("/upload")
    public String fileUpload( MultipartFile multipartFile ){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        return result;
    } // func end



    // [2] 다운로드
    @GetMapping("/download")
    public void fileDownload(@RequestParam String fileName , HttpServletResponse response ){
        fileService.fileDownload( fileName , response );
    }

    // [3] 파일삭제
    @GetMapping( "/delete")
    public boolean fileDelete( @RequestParam String fileName ){
        boolean result = fileService.fileDelete( fileName );
        return result;
    }
} // class end
