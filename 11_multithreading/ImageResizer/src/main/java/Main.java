
import java.io.File;
import java.io.IOException;
import java.lang.Object;



public class Main {

    public static void main(String[] args) throws IOException {
        String dstFolder = "E:\\skillbox\\11_multithreading\\Images\\dst";
        String srcFolder = "E:\\skillbox\\11_multithreading\\Images\\src";

        File srsDir = new File(srcFolder);
        File[] files = srsDir.listFiles();

        long start = System.currentTimeMillis();

        int cntProc = Runtime.getRuntime().availableProcessors();
        int sizePart = files.length/cntProc ;
        int srsPos = 0;
        int mod = files.length%cntProc;

        for (int i = 1; i <= cntProc; i++){

            if (i == cntProc) {
                sizePart -= mod;
            }
            File[] files1 = new File[sizePart];
            System.arraycopy(files, srsPos, files1, 0, files1.length);
            ImagerResizer resized1 = new ImagerResizer(files1, dstFolder, start);
            resized1.start();
            srsPos += sizePart;
        }

    }
}
