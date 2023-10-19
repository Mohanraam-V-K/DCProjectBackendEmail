package com.example.quartz_email_scheduler.services;

import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import com.example.quartz_email_scheduler.payload.CustomerBill;

public class Pdfmaker {
    public void createPdf(CustomerBill bill) {
        try {
            // JSON data
            // Map<String, Object> data = Map.of(
            //     "plan_type", "mobile",
            //     "planName", "super 80",
            //     "planAmount", 80.0,
            //     "planDuration", 30,
            //     "planDueDate", "2023-10-18T16:25:00",
            //     "customerId", "296e37d8-3749-4b7d-b076-e5b6912836a8"
            // );

            Map<String , Object> data = Map.of(
                "plan_type", bill.getPlan_type(),
                "planName", bill.getPlanName(),
                "planAmount", bill.getPlanAmount(),
                "planDuration", bill.getPlanDuration(),
                "planDueDate", bill.getPlanDueDate(),
                "customerId", bill.getCustomerId()
            ); 

            // Create a new document
            PDDocument document = new PDDocument();

            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Create content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set font and font size
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD_OBLIQUE), 18);

            // Add a title
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 750);
            contentStream.showText("Bill for " + data.get("planName"));
            contentStream.endText();

            // Set font and font size for regular text
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);

            // Add bill details
            int yOffset = 700;
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                contentStream.beginText();
                contentStream.newLineAtOffset(100, yOffset);
                contentStream.showText(key + ": " + value.toString());
                contentStream.endText();
                yOffset -= 20;
            }

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save("bill.pdf");

            // Close the document
            document.close();

            System.out.println("Bill PDF created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}