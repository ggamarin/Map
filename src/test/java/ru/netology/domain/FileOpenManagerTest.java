package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager fileOpenManager = new FileOpenManager();

    private String video = "VLC";
    private String browser = "Google Chrome";
    private String image = "Paint";

    private String avi = ".avi";
    private String html = ".html";
    private String png = ".png";
    private String jpg = ".jpg";

    @BeforeEach
    void setUp() {
        fileOpenManager.register(video, avi);
        fileOpenManager.register(browser, html);
        fileOpenManager.remove(".jpg");
        fileOpenManager.register(image, png);
        fileOpenManager.register(image, jpg);
    }

    @Test
    void shouldShowAllApps() {
        Set<String> actual = fileOpenManager.showAllApps();
        Set<String> expected = new HashSet<>();
        expected.add(video);
        expected.add(image);
        expected.add(browser);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowAllTypes() {
        Collection<String> actual = fileOpenManager.showAllTypes();
        List<String> expected = Arrays.asList(avi, html, jpg, png);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByType() {
        String expected = "Paint";
        String actual = fileOpenManager.getName(".jpg");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByTypeIfUsedUppercase() {
        String expected = "Paint";
        String actual = fileOpenManager.getName(".JPG");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByTypeIfUsedNoExistType() {
        String actual = fileOpenManager.getName(".jpeg");
        assertNull(actual);
    }

    @Test
    void shoouldRemoveAssociation() {
        String actual = fileOpenManager.remove("Google Chrome");
        assertNull(actual);
    }
}
