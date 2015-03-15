package com.sorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 17/08/2014
 * {@link http://edunow.su/site/content/algorithms/sortirovka_massiva}
 * {@link http://study-java.ru/uroki-java/urok-11-sortirovka-massiva/}
 *
 * Алгоритмы сортировки:
 * 1. Сортировка пузырьком (Bubble sort)
 *    Алгоритм состоит из повторяющихся проходов по сортируемому массиву. За каждый проход элементы последовательно сравниваются попарно и, если порядок в паре неверный, выполняется обмен элементов. Проходы по массиву повторяются N-1 раз или до тех пор, пока на очередном проходе не окажется, что обмены больше не нужны, что означает — массив отсортирован. При каждом проходе алгоритма по внутреннему циклу, очередной наибольший элемент массива ставится на своё место в конце массива рядом с предыдущим «наибольшим элементом», а наименьший элемент перемещается на одну позицию к началу массива («всплывает» до нужной позиции как пузырёк в воде, отсюда и название алгоритма).
 *    >>> Метод пузырька оказывается крайне неэффективным на любом входном наборе данных. Единственный плюс алгоритма - простота его исполнения.
 * 2. Сортировка вставками (Insertion sort)
 *    На каждом шаге алгоритма мы выбираем один из элементов входных данных и вставляем его на нужную позицию в уже отсортированном списке, до тех пор, пока набор входных данных не будет исчерпан. Метод выбора очередного элемента из исходного массива произволен; может использоваться практически любой алгоритм выбора. Обычно (и с целью получения устойчивого алгоритма сортировки), элементы вставляются по порядку их появления во входном массиве. Приведенный ниже алгоритм использует именно эту стратегию выбора.
 *    >>> Метод оказывается эффективным только на маленьких массивах (не более 10), на массивах больших размеров, в силу асимптотической сложности n^2, алгоритм оказывается крайне не эффективным.
 * 3. Сортировка выбором (Selection sort)
 *    Шаги алгоритма: находим номер минимального значения в текущем списке, производим обмен этого значения со значением первой неотсортированной позиции (обмен не нужен, если минимальный элемент уже находится на данной позиции), теперь сортируем хвост списка, исключив из рассмотрения уже отсортированные элементы. Для реализации устойчивости алгоритма необходимо в пункте 2 минимальный элемент непосредственно вставлять в первую неотсортированную позицию, не меняя порядок остальных элементов.
 *    >>> Метод оказывается эффективным только на маленьких массивах (не более 10), на массивах больших размеров, в силу асимптотической сложности n^2, алгоритм оказывается крайне не эффективным.
 * 4. Сортировка слиянием (Merge sort)
 *    Для решения задачи сортировки эти три этапа выглядят так: 1) Сортируемый массив разбивается на две части примерно одинакового размера; 2) Каждая из получившихся частей сортируется отдельно, например — тем же самым алгоритмом; 3) Два упорядоченных массива половинного размера соединяются в один. 1.1. - 2.1. Рекурсивное разбиение задачи на меньшие происходит до тех пор, пока размер массива не достигнет единицы (любой массив длины 1 можно считать упорядоченным). 3.1. Соединение двух упорядоченных массивов в один. Основную идею слияния двух отсортированных массивов можно объяснить на следующем примере. Пусть мы имеем два подмассива. Пусть также, элементы подмассивов в каждом из этих подмассивов отсортированы по возрастанию. Тогда: 3.2. Слияние двух подмассивов в третий результирующий массив. На каждом шаге мы берём меньший из двух первых элементов подмассивов и записываем его в результирующий массив. Счетчики номеров элементов результирующего массива и подмассива из которого был взят элемент увеличиваем на 1.3. "Прицепление" остатка. Когда один из подмассивов закончился, мы добавляем все оставшиеся элементы второго подмассива в результирующий массив.
 *    >>> Метод оказывается крайне эффективным, однако требуется выделение дополнительной памяти.
 * 5. Быстрая сортировка (Quicksort)
 *    ...
 *    >>> Метод показывает высокую эффективноть, при этом он не требует расходов на дополнительную память. Однако, в худшем случае алгоритм оказывается крайне медленным (O(n2)).
 */
public class SelectionSortMain {

    public static void main(String[] args){

        int[] myArr = new int[] {16, 17, 18, 9, 10, 1, 2, 13, 14, 19, 20, 15, 6, 7, 3, 4, 5, 11, 12, 8};
        System.out.print("                ");
        for(int i = 0; i < myArr.length; i++){
            System.out.print( myArr[i] + " ");
        }
        System.out.println("");


        // Сортировка выбором
        selectionSort(myArr);
        System.out.print("Selection Sort: ");
        for(int i = 0; i < myArr.length; i++){
            System.out.print( myArr[i] + " ");
        }
        System.out.println("");


        myArr = new int[] {16, 17, 18, 9, 10, 1, 2, 13, 14, 19, 20, 15, 6, 7, 3, 4, 5, 11, 12, 8};
        // Сортировка пузырьком
        bubbleSort(myArr);
        System.out.print("Bubble Sort:    ");
        for(int i = 0; i < myArr.length; i++){
            System.out.print( myArr[i] + " ");
        }
        System.out.println("");


        myArr = new int[] {16, 17, 18, 9, 10, 1, 2, 13, 14, 19, 20, 15, 6, 7, 3, 4, 5, 11, 12, 8};
        // Сортировка массива при помощи метода sort() из класса Arrays - Сортировка массива целых чисел по возрастанию:
        Arrays.sort(myArr);
        System.out.print("sort():         ");
        for(int i = 0; i < myArr.length; i++){
            System.out.print( myArr[i] + " ");
        }
        System.out.println("");

        Integer[] myArr2 = new Integer[] {16, 17, 18, 9, 10, 1, 2, 13, 14, 19, 20, 15, 6, 7, 3, 4, 5, 11, 12, 8};
        // Сортировка массива при помощи метода sort() из класса Arrays - Сортировка массива целых чисел по убыванию:
        Arrays.sort(myArr2, Collections.reverseOrder());
        System.out.print("reverseOrder(): ");
        for(int i = 0; i < myArr2.length; i++){
            System.out.print( myArr2[i] + " ");
        }
        System.out.println("");
    }

    /**
     * Реализация алгоритма Сортировка пузырьком на Java (по возрастанию):
     *
     * @param arr
     * @return
     */
    public static void selectionSort(int[] arr){
    /* По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...) */
        for (int i = 0; i < arr.length; i++) {
        /* Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /* В оставшейся части подмножества ищем элемент, который меньше предположенного минимума */
            for (int j = i+1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /* Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами */
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
    /* Внешний цикл каждый раз сокращает фрагмент массива, так как внутренний цикл каждый раз ставит в конец фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /* Сравниваем элементы попарно, если они имеют неправильный порядок, то меняем местами */
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
