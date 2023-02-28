package org.gaba.utils.unzipper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzipper {

    public static boolean unzip(String input, String output) {

        try(ZipInputStream in = new ZipInputStream(new FileInputStream(input)))
        {
            ZipEntry entry;

            while((entry = in.getNextEntry()) != null){

                FileOutputStream out = new FileOutputStream(output + entry.getName());
                for (int c = in.read(); c != -1; c = in.read()) {
                    out.write(c);
                }
                out.flush();
                in.closeEntry();
                out.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

}
