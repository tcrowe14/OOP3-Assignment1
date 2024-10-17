# OOP3-Assignment1
<pre>
Complexity and Sorting

Installation and Usgae Instructions

Installation and Program Start

1. Unzip A1TeamGanon.zip to a local folder.
2. From that folder open a command prompt.
3. From the command prompt inside the extracted folder with the Sort.jar file type: java -jar Sort.jar -fshapes1.txt -tv -sb
4. Follow the usage instructions below to set the parameters you'd like to search by and which type of sort to use.

Usage Instructions

This program takes an input file of shapes and 3 arguments to function (Note: The arguments can be used in whichever order you'd like and are case insensitive), and will return a sorted list as well as a time in milliseconds it took to process the sorting algorithm:

 - File location: for the shapes you'd like to sort, designated by the -f argument, followed by the file path.
   - If the file is located in the folder with the Sort.jar file, you can specify just the file name: -fshapes1.txt
   - Otherwise use the full file path: C:\Code\Java\OOP3-Assignment1\shapes1.txt
   - Examples:
               java -jar Sort.jar -fshape1.txt -tv -sb
               java -jar Sort.jar -f"C:\Code\Java\OOP3-Assignment1\shapes1.txt" -tv -sb
 
 - Sort By: You can sort in 3 different ways, by Volume, Height or Base Area of the shape, using the argument -t:
   - To sort by Volume use -tv
   - To sort by Height use -th
   - To sort by Base Area use -ta
   - Examples:
               Volume: java -jar Sort.jar -fshape1.txt -tv -sb
               Height: java -jar Sort.jar -fshape1.txt -th -sb
               Base Area: java -jar Sort.jar -fshape1.txt -ta -sb

 - Sorting Algorithm: You may choose between 7 sorting algorithms to use, using the argument -s:
   - Bubble Sort: -sb
   - Insertion Sort: -si
   - Selection Sort -ss
   - Merge Sort: -sm
   - Quick Sort: -sq
   - Gnome Sort: -sg
   - Heap Sort: -sh
   - Examples:
              Bubble Sort: java -jar Sort.jar -fshape1.txt -tv -sb
              Insertion Sort: java -jar Sort.jar -fshape1.txt -TH -SI
              Selection Sort: java -jar Sort.jar -fshape1.txt -tA -sS
              Merge Sort: java -jar Sort.jar -f"C:\Code\Java\OOP3-Assignment1\shapes1.txt" -tv -sM
              Quick Sort: java -jar Sort.jar -f"C:\Code\Java\OOP3-Assignment1\shapes1.txt" -tH -sq
              Gnome Sort: java -jar Sort.jar -f"C:\Code\Java\OOP3-Assignment1\shapes1.txt" -tv -sg
              Heap Sort: java -jar Sort.jar -f"C:\Code\Java\OOP3-Assignment1\shapes1.txt" -tA -sh
               
</pre>
