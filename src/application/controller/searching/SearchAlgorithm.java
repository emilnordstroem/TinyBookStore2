package application.controller.searching;

import application.models.book.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchAlgorithm <T extends Searchable<String>> extends Thread {
    private final List<T> list;
    private final String target;
    private final List<T> matches = new ArrayList<>();

    public SearchAlgorithm(List<T> list, String target) {
        this.list = list;
        this.target = target;
    }

    @Override
    public void run() {
        for(T element : list){
            if(element.matched(target)){
                matches.add(element);
            }
        }
    }

    public List<T> getMatches() {
        return matches;
    }
}