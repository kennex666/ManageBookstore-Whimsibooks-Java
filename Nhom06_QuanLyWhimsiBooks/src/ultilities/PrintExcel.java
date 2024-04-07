package ultilities;
import com.spire.xls.Workbook;

import javax.print.PrintService;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintExcel {

    public static void printer(String path) throws Exception{

        //Create a workbook and load an Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(path);

        //Create a PrinterJob object
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        //Specify printer name
       // PrintService myPrintService = findPrintService("\\\\192.168.1.104\\HP LaserJet P1007");
        //printerJob.setPrintService(myPrintService);

        //Create a PageFormat object and set it to the default size and orientation
        PageFormat pageFormat  = printerJob.defaultPage();

        //Return a copy of the Paper object associated with this PageFormat.
        Paper paper = pageFormat .getPaper();

        //Set the imageable area of this Paper.
        paper.setImageableArea(0,0,pageFormat .getWidth(),pageFormat .getHeight());

        //Set the Paper object for this PageFormat.
        pageFormat .setPaper(paper);

        //Set the number of copies
        printerJob .setCopies(1);

        //Call painter to render the pages in the specified format
        printerJob .setPrintable(workbook,pageFormat);

        //execute print
        try {
            printerJob.print();

        } catch (PrinterException e) {
        }
    }
    //Get print service by printer name
    private static PrintService findPrintService(String printerName) {

        PrintService[] printServices = PrinterJob.lookupPrintServices();
        for (PrintService printService : printServices) {
            if (printService.getName().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }
}