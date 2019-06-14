package com.dvla.example.servicetests;

import com.dvla.example.servicehelpers.DataServiceHelpers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class DataServiceHelpersTests {

    private DataServiceHelpers serviceHelpers;

    @Before
    public void createFileReaderUtilTestInstance() throws IOException {
        serviceHelpers = new DataServiceHelpers();
    }

    @Test
    public void getExistingFileFromFolderTest() {
        Assert.assertEquals("vehiclesearch.csv", serviceHelpers.getSpecificFileFromAllFilesWithinFolder("vehiclesearch.csv").getName());
    }

    @Test
    public void getNonExistingFileFromFolderTest() {
         Assert.assertTrue(serviceHelpers.getSpecificFileFromAllFilesWithinFolder("newtextdgfgffgocument.csv") == null);
    }

    @Test
    public void assertValidFileDataTest() throws IOException {
        List<List<String>> dataRecords;
        dataRecords = serviceHelpers.readFileDataRecord("vehiclesearch.csv");
        Assert.assertThat(dataRecords.get(0).get(0), is("KC56 VKJ"));
    }

    @Test(expected = NullPointerException.class)
    public void assertFileNotFoundExceptionIsRaisedWhenActuallyReadingTheFile() throws IOException{
        serviceHelpers.readFileDataRecord("nonexistingfile.csv");
    }

    @Test
    public void assertFileExtensionIsAsExpected(){
        Assert.assertEquals( "csv", serviceHelpers.getFileExtensionOfFileWithinDirectory("vehiclesearch.csv"));
    }

    @Test
    public void assertFileSizeIsAsExpected(){
        Assert.assertEquals( "826 kb", serviceHelpers.getFileSizeInKbWithinDirectory("Desert.jpg").toString());
    }

    @Test
    public void assertFileMimeTypeIsAsExpected(){
        Assert.assertEquals("image/jpeg", serviceHelpers.getMimeTypeOfFileInDirectory("Desert.jpg"));
    }

    @Test
    public void assertNullMimeType(){
        Assert.assertEquals(null, serviceHelpers.getMimeTypeOfFileInDirectory("vehiclesearch.csv"));
    }

    @Test
    public void assertReadAllFilesCount(){
        Assert.assertEquals(11, serviceHelpers.files.size());
    }
}