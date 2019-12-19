/** @file LZ78Test.java
 * @brief Aquest és el test unitari de l'algorisme LZ78.
 *
 * Els imports que utilitza són:
 *       - import java.io.*
 *       - import junit.framework.Assert
 *       - import org.junit.Test
 *       - import org.apache.commons.io.FileUtils
 *       - import Domain.LZ78
 *
 * @author Carlos Gascón Dominguez
 */

package Domain.Tests;

import java.io.*;
import junit.framework.Assert;
import org.junit.Test;
import org.apache.commons.io.FileUtils;
import Domain.*;
import Persistence.CtrlPersistence;

/*
 * Test unitari de l'algorisme LZ78
 */

/** @class LZ78Test
 * @brief Aquest és el test unitari de l'algorisme LZ78.
 *
 * @author Carlos Gascón Dominguez
 */
public class LZ78Test {
    /** @brief Path del fitxer d'entrada per la compressió i referent per comparar a la descompressió. */
    private final String in_path = "C:\\Users\\carlos.gascon.dominguez\\Desktop\\data\\JocsDeProves\\LZ78Test\\lz78sample1.txt";
    /** @brief Path del fitxer de sortida del test de compressió.*/
    private final String out_path = "C:\\Users\\carlos.gascon.dominguez\\Desktop\\data\\JocsDeProves\\LZ78Test\\comptest.lz78";
    /** @brief Path del fitxer d'entrada per la descompressió i referent per comparar a la compressió*/
    private final String in_path2 = "C:\\Users\\carlos.gascon.dominguez\\Desktop\\data\\JocsDeProves\\LZ78Test\\lz78comp1.lz78";
    /** @brief Path del fitxer de sortida del test de descompressió */
    private final String out_path2 = "C:\\Users\\carlos.gascon.dominguez\\Desktop\\data\\JocsDeProves\\LZ78Test\\dectest.txt";
    
    private static CtrlPersistence ctrlPersistence = CtrlPersistence.getInstance();
    
    private final Algorithm algorithm = new LZ78();
    
    /** @brief Creadora per defecte.
     *
     * \pre <em>Cert.</em>
     * \post Crea una instància de la classe LZ78Test.
     */
    public LZ78Test() {};

    /** @brief Test del mètode de compressió de la classe LZ78.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCompress() throws Exception {
        
        System.out.println("**Testing compress**");
        //BufferedInputStream inBuffer = new BufferedInputStream (new FileInputStream (in_path));
        //BufferedOutputStream outBuffer = new BufferedOutputStream (new FileOutputStream (out_path));
        ctrlPersistence.openFile(in_path, out_path);
        //LZ78 instance = new LZ78();
        algorithm.set_isFile(true);
        algorithm.compress();
        File expected = new File(in_path2);
        File output = new File(out_path);
        Assert.assertTrue("Són diferents !", FileUtils.contentEquals(expected,output));
    }

    /** @brief Test del mètode de descompressió de la classe LZ78.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDecompress() throws Exception {
        System.out.println("**Testing decompress**");
        //BufferedInputStream inBuffer = new BufferedInputStream (new FileInputStream (in_path2));
        //BufferedOutputStream outBuffer = new BufferedOutputStream (new FileOutputStream (out_path2));
        ctrlPersistence.openFile(in_path2, out_path2);
        //LZ78 instance = new LZ78();
        algorithm.set_isFile(true);
        algorithm.decompress();
        File expected = new File(in_path);
        File output = new File(out_path2);
        Assert.assertTrue("Són diferents !", FileUtils.contentEquals(expected,output));
    }
}
