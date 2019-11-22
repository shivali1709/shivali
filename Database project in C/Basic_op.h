    //INSERTION
    void insert_snap(Tuple_snap A , Hashtable H){// second parameter would be an array of linkedlists
    int sId=A.StudentId;
    int key= hash_sId(sId);
    Tuple_snap* ptr=malloc(sizeof(Tuple_snap));
    *ptr = A;
    LinkedList_add_at_end(H[key],ptr);
    }

    void insert_csg(Tuple_csg A , Hashtable H){
    int sId=A.StudentId;
    int key= hash_sId(sId);
    Tuple_csg* ptr=malloc(sizeof(Tuple_csg));
    *ptr = A;
    LinkedList_add_at_end(H[key],ptr);
    }

    void insert_cdh(Tuple_cdh A , Hashtable H){
    char* crs=A.Course;
    int key= hash_crs(crs);
    Tuple_cdh* ptr=malloc(sizeof(Tuple_cdh));
    *ptr = A;
    LinkedList_add_at_end(H[key],ptr);
    }

    void insert_cr(Tuple_cr A , Hashtable H){
    char* crs=A.Course;
    int key= hash_crs(crs);
    Tuple_cr* ptr=malloc(sizeof(Tuple_cr));
    *ptr = A;
    LinkedList_add_at_end(H[key],ptr);
    }

    void insert_cp(Tuple_cp A , Hashtable H){
    char* crs=A.Course;
    int key= hash_crs(crs);
    Tuple_cp* ptr=malloc(sizeof(Tuple_cp));
    *ptr = A;
    LinkedList_add_at_end(H[key],ptr);
    }

















    // DELETION
    void delete_snap(char* sId, char* name, char* adr, char* ph, Hashtable H){
    if(strcmp("*",sId)!=0){
    int x;
    sscanf(sId, "%d", &x);
    int key= hash_sId(x);
    printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_snap temp;
            temp= *tempAddress;
            if(x==temp.StudentId){//here we should check all the other parameters as well but doesn't make sense!
            LinkedList_remove(H[key],tempAddress);
           // printf("removed");
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{
            //printf("REMOVING FROM THE ASTERIX CASE");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_snap temp;
            temp= *tempAddress;

            if((strcmp(temp.Name,name)==0||strcmp(name,"*")==0) && (strcmp(temp.Address,adr)==0||strcmp(adr,"*")==0)&& (strcmp(temp.Phone,ph)==0||strcmp(ph,"*")==0)){
                 // printf("match found \n");
                LinkedList_remove(H[i],tempAddress);
                  //printf("REMOVEDDDDDD record at %d", i);
            }else{
            j++;
            }
          printf("\n");
        } free(it);
        }
    }
    }
    }

    void delete_csg( char* course, char* sId, char* gr, Hashtable H){
    if(strcmp("*",sId)!=0){
    int x;
    sscanf(sId, "%d", &x);
    int key= hash_sId(x);
    //printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_csg temp;
            temp= *tempAddress;
            if(x==temp.StudentId){//here we should check all the other parameters as well but doesn't make sense!
            LinkedList_remove(H[key],tempAddress);
           // printf("removed");
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{
            //printf("REMOVING FROM THE ASTERIX CASE");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_csg temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,course)==0||strcmp(course,"*")==0) && (strcmp(temp.Grade,gr)==0||strcmp(gr,"*")==0)){
                 // printf("match found \n");
                LinkedList_remove(H[i],tempAddress);
                  //printf("REMOVEDDDDDD record at %d", i);
            }else{
            j++;
            }
          printf("\n");
        } free(it);
        }
    }
    }
    }

    void delete_cdh( char* cr, char* day, char* hr, Hashtable H){

            //printf("REMOVING FROM THE ASTERIX CASE");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cdh temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,cr)==0||strcmp(cr,"*")==0) && (strcmp(temp.Day,day)==0||strcmp(day,"*")==0)&&(strcmp(temp.Hour,hr)==0||strcmp(hr,"*")==0)){
                 // printf("match found \n");
                LinkedList_remove(H[i],tempAddress);
                  //printf("REMOVEDDDDDD record at %d", i);
            }else{
            j++;
            }
          printf("\n");
        } free(it);
        }
    }

    }

        void delete_cr( char* cr, char* room, Hashtable H){

            //printf("REMOVING FROM THE ASTERIX CASE");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cr* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cr temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,cr)==0||strcmp(cr,"*")==0) && (strcmp(temp.Room,room)==0||strcmp(room,"*")==0)){
                LinkedList_remove(H[i],tempAddress);
                  //printf("REMOVEDDDDDD record at %d", i);
            }else{
            j++;
            }
          printf("\n");
        } free(it);
        }
    }

    }

         void delete_cp( char* cr, char* p, Hashtable H){

            //printf("REMOVING FROM THE ASTERIX CASE");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cp* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cp temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,cr)==0||strcmp(cr,"*")==0) && (strcmp(temp.Prereq,p)==0||strcmp(p,"*")==0)){
                LinkedList_remove(H[i],tempAddress);
                  //printf("REMOVEDDDDDD record at %d", i);
            }else{
            j++;
            }
          printf("\n");
        } free(it);
        }
    }

    }




    //LOOKUP
    void lookup_snap(char* sId, char* name, char* adr, char* ph, Hashtable H){

    if(strcmp("*",sId)!=0){
    int x;
    sscanf(sId, "%d", &x);
    int key= hash_sId(x);
   // printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_snap temp;
            temp= *tempAddress;
            if(x==temp.StudentId){//here we should check all the other parameters as well but doesn't make sense!
        //  LinkedList_remove(H[key],tempAddress);
           // printf("found it!");
            printf("\n%d %s %s %s \n",temp.StudentId, temp.Name, temp.Address, temp.Phone);
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{

            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_snap temp;
            temp= *tempAddress;

            if((strcmp(temp.Name,name)==0||strcmp(name,"*")==0) && (strcmp(temp.Address,adr)==0||strcmp(adr,"*")==0)&& (strcmp(temp.Phone,ph)==0||strcmp(ph,"*")==0)){
            printf("\n%d %s %s %s \n",temp.StudentId, temp.Name, temp.Address, temp.Phone);
            }
            j++;


        } free(it);
        }
    }


    }
    }


    void lookup_csg(char* crs, char* sId, char* grd, Hashtable H){

    if(strcmp("*",sId)!=0){
    int x;
    sscanf(sId, "%d", &x);
    int key= hash_sId(x);
   // printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_csg temp;
            temp= *tempAddress;
            if(x==temp.StudentId){//here we should check all the other parameters as well but doesn't make sense!

            printf("\n%s %d %s \n",temp.Course, temp.StudentId, temp.Grade);
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{

            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_csg temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,crs)==0||strcmp(crs,"*")==0) && (strcmp(temp.Grade,grd)==0||strcmp(grd,"*")==0)){
            printf("\n%s %d %s \n",temp.Course, temp.StudentId, temp.Grade);
            }
            j++;

        } free(it);
        }
        }
    }
}



    void lookup_cdh(char* crs, char* day, char* hr, Hashtable H){

    if(strcmp("*",crs)!=0){
    int key= hash_crs(crs);
   // printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_cdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_cdh temp;
            temp= *tempAddress;
            if(strcmp(crs,temp.Course)==0){//here we should check all the other parameters as well but doesn't make sense!

            printf("\n%s %s %s \n",temp.Course, temp.Day, temp.Hour);
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{

            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cdh temp;
            temp= *tempAddress;

            if((strcmp(temp.Day,day)==0||strcmp(day,"*")==0) && (strcmp(temp.Hour,hr)==0||strcmp(hr,"*")==0)){
            printf("\n%s %s %s \n",temp.Course, temp.Day, temp.Hour);
            }
            j++;

        } free(it);
        }
        }
    }
}

    void lookup_cp(char* crs, char* pr, Hashtable H){

    if(strcmp("*",crs)!=0){
    int key= hash_crs(crs);
   // printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_cp* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_cp temp;
            temp= *tempAddress;
            if(strcmp(crs,temp.Course)==0){//here we should check all the other parameters as well but doesn't make sense!

            printf("\n%s %s\n",temp.Course, temp.Prereq);
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{

            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cp* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cp temp;
            temp= *tempAddress;

            if((strcmp(temp.Prereq,pr)==0||strcmp(pr,"*")==0) && (strcmp(temp.Course,crs)==0||strcmp(crs,"*")==0)){
            printf("\n%s %s\n",temp.Course, temp.Prereq);
            }
            j++;

        } free(it);
        }
        }
    }
}

    void lookup_cr(char* crs, char* room, Hashtable H){

    if(strcmp("*",crs)!=0){
    int key= hash_crs(crs);
   // printf("%d", key);

       LinkedListIterator it= LinkedList_iterator(H[key]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            Tuple_cr* tempAddress;
            tempAddress=LinkedList_elementAt(H[key],j);
            Tuple_cr temp;
            temp= *tempAddress;
            if(strcmp(crs,temp.Course)==0){//here we should check all the other parameters as well but doesn't make sense!

            printf("\n%s %s\n",temp.Course, temp.Room);
            break;
            }
            j++;
            LinkedListIterator_next(it);

        }
        free(it);
    }else{

            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_cr* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cr temp;
            temp= *tempAddress;

            if((strcmp(temp.Course,crs)==0||strcmp(crs,"*")==0) && (strcmp(temp.Room,room)==0||strcmp(room,"*")==0)){
            printf("\n%s %s\n",temp.Course, temp.Room);
            }
            j++;

        } free(it);
        }
        }
    }
}





    //PRINT
    void print_snap(Hashtable H){
    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){
          //  printf("___%d \n", i);
        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            printf("Index: %i Tuple: ", i);
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_snap temp;
            temp= *tempAddress;
            j++;
            printf("%d %s %s %s",temp.StudentId, temp.Name, temp.Address, temp.Phone);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
    }

    void print_csg(Hashtable H){
    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){

        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
             printf("Index: %i Tuple: ", i);
            Tuple_csg* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_csg temp;
            temp= *tempAddress;
            j++;
            printf("%s %d %s \n",temp.Course, temp.StudentId, temp.Grade);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
    }

    void print_cdh(Hashtable H){
    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){

        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            printf("Index: %i Tuple: ", i);
            Tuple_cdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cdh temp;
            temp= *tempAddress;
            j++;
            printf("%s %s %s\n",temp.Course, temp.Day, temp.Hour);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
    }

    void print_cp(Hashtable H){
    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){

        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            printf("Index: %i Tuple: ", i);
            Tuple_cp* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cp temp;
            temp= *tempAddress;
            j++;
            printf("%s %s\n",temp.Course, temp.Prereq);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
    }

    void print_cr(Hashtable H){
    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){

        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            printf("Index: %i Tuple: ", i);
            Tuple_cr* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_cr temp;
            temp= *tempAddress;
            j++;
            printf("%s %s\n",temp.Course, temp.Room);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
    }

    void print_gen(Hashtable H_new){

                for(int k=0; k<100; k++){
                 LinkedListIterator it_gen= LinkedList_iterator(H_new[k]);
                 int l=0;
                 while(LinkedListIterator_hasNext(it_gen)){
                printf("Tuple: ");
                Tuple_gen* tempAddress_gen;
                tempAddress_gen=LinkedList_elementAt(H_new[k],l);
                Tuple_gen temp_gen;
                temp_gen= *tempAddress_gen;

                printf("\n%s\n",temp_gen.Property);
                LinkedListIterator_next(it_gen);
                l++;
                 }
                }
}


    void print_crdh(Hashtable H){


    for(int i=0; i<100; i++){
        if (LinkedList_isEmpty(H[i])){
           // printf("___%d \n", i);
        }else{
       LinkedListIterator it= LinkedList_iterator(H[i]);
       int j=0;
       while(LinkedListIterator_hasNext(it)){
            printf("Tuple: ", i);
            Tuple_crdh* tempAddress;
            tempAddress=LinkedList_elementAt(H[i],j);
            Tuple_crdh temp;
            temp= *tempAddress;
            j++;
            printf("%s %s %s %s\n",temp.Course,temp.Room, temp.Day, temp.Hour);
            LinkedListIterator_next(it);
            printf("\n");
        }
        }
    }
}












