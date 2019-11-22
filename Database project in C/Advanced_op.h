void select_CSG(char* crs, Hashtable H, Hashtable H_new){
    //now key is on student, so you will have to iterate through the whole list

       for(int i=0; i<100; i++){
       H_new[i]=new_LinkedList();
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){

            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_csg temp;
            temp= *tempAddress;
            j++;
            if(strcmp(temp.Course,crs)==0){
            Tuple_csg* ptr=malloc(sizeof(Tuple_csg));
            *ptr = temp;
            LinkedList_add_at_end(H_new[i],ptr);
            //printf("\n%s %d %s \n",temp.Course, temp.StudentId, temp.Grade);
            }
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }

    void select_CRDH(char* room, Hashtable H, Hashtable H_new){
    //now key is on student, so you will have to iterate through the whole list

       for(int i=0; i<100; i++){
       H_new[i]=new_LinkedList();
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){

            Tuple_crdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_crdh temp;
            temp= *tempAddress;
            j++;
            if(strcmp(temp.Room,room)==0){
            Tuple_crdh* ptr=malloc(sizeof(Tuple_crdh));
            *ptr = temp;
            LinkedList_add_at_end(H_new[i],ptr);
            //printf("\n%s %d %s \n",temp.Course, temp.StudentId, temp.Grade);
            }
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }

    void project_CSG(char* attribute, Hashtable H, Hashtable H_new){

      for(int i=0; i<100; i++){
         H_new[i]=new_LinkedList();
      }
       for(int i=0; i<100; i++){
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
        char* result;
        int key;
       while(LinkedListIterator_hasNext(it)){
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_csg temp;
            temp= *tempAddress;
            j++;
            Tuple_gen gen;
            if(strcmp(attribute,"StudentId")==0){
            int num=temp.StudentId;
            result=malloc(sizeof(char)*32);
            sprintf(result, "%d", num);
            key=hash_sId(num);
            strcpy(gen.Property,result);
            free(result);
            result=NULL;
            }
            if( strcmp(attribute,"Course")==0){
            key=hash_crs(temp.Course);
            strcpy(gen.Property,temp.Course);
            }
            if( strcmp(attribute,"Grade")==0){
            key=hash_crs(temp.Grade);

            strcpy(gen.Property,temp.Grade);
            }
            Tuple_gen* ptr= malloc(sizeof(Tuple_gen));
            *ptr = gen;
            if((LinkedList_isEmpty(H_new[key]))||(!(strcmp(LinkedList_elementAt(H_new[key],0),gen.Property)==0))){
            LinkedList_add_at_end(H_new[key],ptr);
            }else{
            }
            LinkedListIterator_next(it);
            free(tempAddress);
            tempAddress=NULL;
            }
        }
    }



    void project_CR(Hashtable H, Hashtable H_new){
      for(int i=0; i<100; i++){
      H_new[i]=new_LinkedList();
      }

       for(int i=0; i<100; i++){
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
        int key;
       while(LinkedListIterator_hasNext(it)){

            Tuple_crdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_crdh temp;
            temp= *tempAddress;
            j++;
            Tuple_gen2 gen2;
            key=hash_crs(temp.Day);

            strcpy(gen2.Property,temp.Day);
            strcpy(gen2.Property2,temp.Hour);
            Tuple_gen2* ptr= malloc(sizeof(Tuple_gen2));
            *ptr = gen2;



            if((LinkedList_isEmpty(H_new[key]))){
            LinkedList_add_at_end(H_new[key],ptr);
            printf("%s \t %s \n", gen2.Property, gen2.Property2);
            }else{
            Tuple_gen2* compareAddress= LinkedList_elementAt(H_new[key],0);

            Tuple_gen2 compare= *compareAddress;

            if((!(strcmp(compare.Property2,gen2.Property2)==0))){
            LinkedList_add_at_end(H_new[key],ptr);
            printf("%s \t %s \n", gen2.Property, gen2.Property2);

            }
            }




            LinkedListIterator_next(it);
            free(tempAddress);
            tempAddress=NULL;
            }
        }
    }




    void join_CDH_CR(Hashtable H1, Hashtable H2, Hashtable H_new){
      for(int i=0; i<100; i++){
         H_new[i]=new_LinkedList();
      }

      for(int i=0; i<100; i++){
        LinkedListIterator it= LinkedList_iterator(H1[i]);
        int j=0;

        int key;
        while(LinkedListIterator_hasNext(it)){
        Tuple_cdh* tempAddress;
        tempAddress= LinkedList_elementAt(H1[i],j);
        j++;
        Tuple_cdh temp;
        temp=*tempAddress;
        key=hash_crs(temp.Course);
        LinkedListIterator it2= LinkedList_iterator(H2[key]);
        int k=0;
        while(LinkedListIterator_hasNext(it2)){
        Tuple_cr* tempAddress2;
        tempAddress2= LinkedList_elementAt(H2[key],k);
        k++;
        Tuple_cr temp2;
        temp2=*tempAddress2;
        if(strcmp(temp2.Course,temp.Course)==0){

        Tuple_crdh crdh_temp;
        strcpy(crdh_temp.Course, temp.Course);
        strcpy(crdh_temp.Room,temp2.Room);
        strcpy(crdh_temp.Day,temp.Day);
        strcpy(crdh_temp.Hour,temp.Hour);
        Tuple_crdh* ptr= malloc(sizeof(Tuple_crdh));
        *ptr = crdh_temp;
        LinkedList_add_at_end(H_new[key],ptr);

        }else{
        printf("found no match \n");
        }
        LinkedListIterator_next(it2);
        }
        LinkedListIterator_next(it);
        }
      }
}


