/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author dushyant
 */
public class Decompress {
    public static void decompressFunction(File file) throws IOException{
        String fileDirectory=file.getParent();
                System.out.println(fileDirectory);
                FileInputStream fis=new FileInputStream(file);  //fetching decompressed file
                GZIPInputStream gzipIS=new GZIPInputStream(fis); //reading+decompress
                FileOutputStream fos=new FileOutputStream(fileDirectory+"/DecompressedFile.txt"); //stroring d file
                
                byte[] buffer=new byte[1024];  //we r taking the array size of 1kb
                int len;
                while((len=gzipIS.read(buffer))!=-1){ //loop=jb tk input file k characters khtm na ho jaye
                    fos.write(buffer,0,len);  //output likhne k liye (fos)
                }
                gzipIS.close();
                fis.close();
                fos.close();
    }
    public static void main(String[] args) throws IOException{
    File path =new File("C:\\Users\\dushyant\\Desktop\\CompressedFile.gz");//compressed file ka path
    decompressFunction(path);
    }
}
