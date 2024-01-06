package algorithm;

import element.Element;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ShellSort extends GeneralSort {

    private void shellSort(Element[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Element temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].getValue() > temp.getValue(); j -= gap) {
                	colorElements(arr, CompareColor, j-gap,j);
                    compareElement(arr, j - gap, j);
                }
                arr[j] = temp;
                colorElements(arr, StartColor, j);
                
            }
        }
    }

    private void compareElement(Element[] arr, int i, int j) {
        colorElements(arr, CompareColor, i, j);
        if (arr[i].getValue() > arr[j].getValue()) {
            swap(arr, i, j);
        }
        colorElements(arr, StartColor, i, j);
        
    }

    @Override
    public Transition[] startSort(Element[] arr) {
        shellSort(arr);
        colorArray(arr, SortedColor);
        return this.transitions;
    }

}
