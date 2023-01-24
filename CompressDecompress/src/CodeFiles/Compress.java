/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author dushyant
 */
public class Compress {

/**
 *
 * @author dushyant
 */

    public static void compressFunction(File file) throws FileNotFoundException, IOException{
        String fileDirectory=file.getParent();  //v r trying to store the dirctory path of our file(dir path of file)
        System.out.println(fileDirectory);
        FileInputStream fis=new FileInputStream(file);  //object v r using for fetching input
        FileOutputStream fos=new FileOutputStream(fileDirectory +"/CompressedFile.gz");//storing o/p
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos); //bytes ko gzip format compress version
        
        byte[] buffer = new byte[1024]; //1024=1kb
        int len;
        
        while((len=fis.read(buffer))!=-1){   //char read karega suppose 2 len vla 
            gzipOS.write(buffer,0,len);    //encryt form m likhega dusri comressed file m
            //  System.out.println(len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException{
    File path = new File("C:\\Users\\dushyant\\Desktop\\pro.txt");
    compressFunction(path);
    }
}
