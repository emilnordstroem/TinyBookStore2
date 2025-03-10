package application.controller.searching;

import application.models.book.Searchable;
import java.util.ArrayList;
import java.util.List;

public class TotalMergeAlgorithm <T extends Searchable<String> & Comparable<T>> {
    private final List<T> mergedList = new ArrayList<>();

    public TotalMergeAlgorithm(List<T> leftList, List<T> rightList) {
        mergeAlgorithm(leftList, rightList);
    }

    public List<T> getMergedList() {
        return new ArrayList<>(mergedList);
    }

    private void mergeAlgorithm(List<T> leftSide, List<T> rightSide){
        int leftSideIndex = 0;
        int rightSideIndex = 0;

        while(leftSideIndex < leftSide.size() && rightSideIndex  < rightSide.size()){
            if(leftSide.get(leftSideIndex).compareTo(rightSide.get(rightSideIndex)) <= 0) {
                mergedList.add(leftSide.get(leftSideIndex));
                leftSideIndex++;
            } else {
                mergedList.add(rightSide.get(rightSideIndex));
                rightSideIndex++;
            }
        }

        while(leftSideIndex < leftSide.size()){
            mergedList.add(leftSide.get(leftSideIndex));
            leftSideIndex++;
        }
        while(rightSideIndex  < rightSide.size()){
            mergedList.add(rightSide.get(rightSideIndex));
            rightSideIndex++;
        }
    }
}