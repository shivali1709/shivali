
#include "LinkedList.h"
#include <string.h>

    typedef LinkedList Hashtable[100];

    typedef struct Tuple_snap {
        int StudentId;
        char Name[255];
        char Address[255];
        char Phone[255];
    } Tuple_snap;

    typedef struct Tuple_crdh{
        char Course[255];
        char Room[255];
        char Day[255];
        char Hour[255];
    }Tuple_crdh;

    typedef struct Tuple_csg {
        char Course[255];
        int StudentId;
        char Grade[255];
    } Tuple_csg;

    typedef struct Tuple_cdh {
        char Course[255];
        char Day[255];
        char Hour[255];
    }Tuple_cdh;

    typedef struct Tuple_cp {
        char Course[255];
        char Prereq[255];
    } Tuple_cp;


    typedef struct Tuple_cr {
        char Course[255];
        char Room[255];
    } Tuple_cr;

    typedef struct Tuple_gen {
        char Property[255];

    }Tuple_gen;

    typedef struct Tuple_gen2 {
        char Property[255];
        char Property2[255];

    }Tuple_gen2;



    int hash_sId(int sId){
   return sId%100;
   }

   int hash_crs(char* crs){
   int result=0;
   int i=0;
   while(i<strlen(crs)){
   result+=crs[i];
   i++;
   }
    return result%100;
   }




