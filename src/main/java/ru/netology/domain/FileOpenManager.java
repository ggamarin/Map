package ru.netology.domain;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> map = new HashMap<>();

    public String remove(String key) {
        return map.remove(key.toLowerCase());
    }

    public void register(String app, String key) {
        map.putIfAbsent(key.toLowerCase(), app);
    }

    public String getName(String key) {
        return map.get(key.toLowerCase());
    }

    public Set<String> showAllApps() {
        Collection<String> result = map.values();
        return new HashSet<>(result);
    }

    public List<String> showAllTypes() {
        Set<String> strings = map.keySet();
        List<String> list = new ArrayList<>(strings);
        FilesCompareByAlphabet compareByAlphabet = new FilesCompareByAlphabet();
        list.sort(compareByAlphabet);
        return list;
    }
}
