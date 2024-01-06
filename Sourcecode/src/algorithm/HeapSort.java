package algorithm;

import element.Element;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HeapSort extends GeneralSort {

    private void heapify(Element[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].getValue() > arr[largest].getValue()) {
            largest = left;
        }

        if (right < n && arr[right].getValue() > arr[largest].getValue()) {
            largest = right;
        }

        if (largest != i) {
        	colorElements(arr, CompareColor,i, largest);
            swap(arr, i, largest);
            colorElements(arr, StartColor,i, largest);
            heapify(arr, n, largest);
        }
    }

    private void buildHeap(Element[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapSort(Element[] arr) {
        int n = arr.length;

        buildHeap(arr);

        for (int i = n - 1; i > 0; i--) {
        	colorElements(arr, CompareColor,0, i);
            swap(arr, 0, i);
            //colorElements(arr, StartColor, 0,i);
            colorElements(arr, SortedColor, i);
            heapify(arr, i, 0);
        }
    }

    @Override
    public Transition[] startSort(Element[] arr) {
        heapSort(arr);
        colorArray(arr, SortedColor);
        return this.transitions;
    }
}
