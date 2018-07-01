# MazeRunner
Game Labirin berbasis Metode Backtracking pada Konsep Kecerdasan Buatan

Mengimplementasi sebuah algoritma pencari jalur kedalam sebuah robot yang dapat mencari jalur dari posisi awal menuju posisi tujuan. Labirin yang dilalui oleh robot akan terdapat halangan yang menghalangi robot untuk menuju posisi tujuan, dalam sekali langkah robot hanya dapat berpindah satulangkah di antara empat arah yaitu :
•	Utara : (x,y) -> (x, y-1)
•	Timur : (x,y) -> (x+1, y)
•	Selatan : (x,y) -> (x, y+1)
•	Barat : (x,y) -> (x-1, y)
AI secara default akan memilih langkah dari utara - timur - selatan - barat

Robot hanya dapat berjalan ke tempat yang tidak memiliki halangan dan harus tetap berada didalam area labirin. Robot harus dapat mencari jalur dari posisi awal ke posisi tujuan (solution path atau goal path), jika robot menemui halangan dalam sebuah jalur robot dapat kembali dan dan mencari jalur lain. Sebagai tambahan, robot dapat menandai jalur yang ia lewati didalam labirin.
