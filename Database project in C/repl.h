
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#include "query.h"
#include "Structs.h"

    void query1(Hashtable h1, Hashtable h2);
    void query2(Hashtable h1, Hashtable h2, Hashtable h3, Hashtable h4);
    int query1Ans(char* qinput,Hashtable h1, Hashtable h2);
    int query2Ans(char* qinput,Hashtable h1, Hashtable h2, Hashtable h3, Hashtable h4);



//navigating among relations
    //given StudentName, Course
    //to find grade
    //H1- snap, H2- csg;
    void lookup_query1(char* sname, char* crs, Hashtable H1, Hashtable H2){

           // printf("MS1 \n");
            for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H1[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H1[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H1[i],j);
            Tuple_snap temp;
            temp= *tempAddress;
           // printf("studentName from query: %s\n",sname);
           // printf("studentName from temp: %s\n", temp.Name);

            if((strcmp(temp.Name,sname)==0)){
            //once we find the record- we have a record with name = say C. Brown; now go in the csg relation and find course and name match..
                              //  printf("MS2 \n");
                                int x=temp.StudentId;
                                //printf("corresponding student_id:%d \n",x);
                                int key= hash_sId(x);
                                LinkedListIterator it2= LinkedList_iterator(H2[key]);
                                int j2=0;
                                while(LinkedListIterator_hasNext(it2)){
                                        Tuple_csg* tempAddress2;
                                        tempAddress2=LinkedList_elementAt(H2[key],j2);
                                        Tuple_csg temp2;
                                        temp2= *tempAddress2;
                                      //  printf("test_print \n%s %d%s \n",temp2.Course, temp2.StudentId, temp2.Grade);
                                        if((x==temp2.StudentId) && (strcmp(temp2.Course, crs)==0)){//here we should check all the other parameters as well but doesn't make sense!
                                        printf("Match Found - ");
                                        printf("%s %s : %s \n",sname, temp2.Course, temp2.Grade);
                                        break;
                                        }
                                        j2++;
                                        LinkedListIterator_next(it2);
                                }
                                free(it2);
            }
            j++;
            } free(it);
            }
            }

    }

    //H1- snap H2-csg H3- cdh H4- cr
    void lookup_query2(char* sname, char* day, char* hour, Hashtable H1, Hashtable H2, Hashtable H3, Hashtable H4 ){
    //printf("MS1");
    for(int i=0; i<100; i++){// go thorugh the complete list
            if (LinkedList_isEmpty(H1[i])){
            //nothing
            }else{
            //printf("--%d--",i);
            LinkedListIterator it= LinkedList_iterator(H1[i]);
            int j=0;
            while(LinkedListIterator_hasNext(it)){
            LinkedListIterator_next(it);
            //printf("\n in again");
            Tuple_snap* tempAddress;
            tempAddress=LinkedList_elementAt(H1[i],j);
            Tuple_snap temp;
            temp= *tempAddress;
            if((strcmp(temp.Name,sname)==0)){
                  //  printf("MS2");
                            int x=temp.StudentId;
                            //printf("corresponding student_id:%d \n",x);
                            int key= hash_sId(x);
                            LinkedListIterator it2= LinkedList_iterator(H2[key]);
                            int j2=0;
                            while(LinkedListIterator_hasNext(it2)){

                                        Tuple_csg* tempAddress2;
                                        tempAddress2=LinkedList_elementAt(H2[key],j2);
                                        Tuple_csg temp2;
                                        temp2= *tempAddress2;
                                        if((x==temp2.StudentId)){
                                         //   printf("MS3");
                                                char* y= temp2.Course;
                                                int key2= hash_crs(y);
                                                LinkedListIterator it3= LinkedList_iterator(H3[key2]);
                                                int j3=0;
                                                while(LinkedListIterator_hasNext(it3)){
                                                 Tuple_cdh* tempAddress3;
                                                 tempAddress3=LinkedList_elementAt(H3[key2],j3);
                                                 Tuple_cdh temp3;
                                                 temp3= *tempAddress3;

                                               /*  printf("\n %s \n",temp3.Course );
                                                 printf("\n %s \n", y);
                                                 printf("\n %s \n",temp3.Day );
                                                 printf("\n %s \n", day);
                                                 printf("\n %s \n", temp3.Hour);
                                                 printf("\n %s \n",hour );
                                                 */

                                                 if((strcmp(y,temp3.Course)==0)&&(strcmp(temp3.Day,day)==0)&&(strcmp(temp3.Hour,hour)==0)){
                                                  //   printf("MS4");
                                                     Tuple_cr* tempAddress4;
                                                 tempAddress4=LinkedList_elementAt(H4[key2],0);
                                                 Tuple_cr temp4;
                                                 temp4=*tempAddress4;
                                                    printf("Match Found-");
                                                    printf("%s %s %s : %s \n",sname, day, hour, temp4.Room);
                                                   break;
                                                 }
                                                 j3++;
                                                 LinkedListIterator_next(it3);
                                                }
                                                free(it3);
                                        //body
                                        }
                                         j2++;
                                        LinkedListIterator_next(it2);
                                        }
                                        free(it2);
}
            j++;
            } free(it);
            }
    }
    }


                            void query1(Hashtable h1, Hashtable h2){
                            printf("What grade did Student get in Course\n");
                            printf("Enter Query: ");
                            char qinput[1024];
                            scanf("%[^\n]%*c",qinput);

                            query1Ans(qinput, h1, h2);
                            }


                            void query2(Hashtable h1, Hashtable h2, Hashtable h3, Hashtable h4){
                            printf("Where is StudentName at Time on Day\n");
                            printf("Enter Query: ");
                            char qinput[9048];
                            scanf("%[^\n]%*c",qinput);
                            query2Ans(qinput, h1, h2,h3,h4);
                            }



                                           int query1Ans(char* qinput, Hashtable h1, Hashtable h2){

                                            char studentName[9048];
                                            char courseName[9048];

                                                long int counter = 15;
                                                long int counter2 = 0;//name counter
                                                long int counter3 = 0;//course counter
                                                int temp_counter;
                                                int temp_counter_assign;
                                                while(1)
                                                {  temp_counter=counter;
                                                    temp_counter_assign=counter;
                                                    if(qinput[temp_counter+1] == 'g' && qinput[temp_counter+2] == 'e' && qinput[temp_counter+3] == 't')
                                                    {
                                                        break;
                                                    }

                                                    else
                                                    {
                                                        studentName[counter2] = qinput[temp_counter_assign];
                                                        counter++;
                                                       counter2++;
                                                    }
                                                }
                                                counter=counter+8;
                                                while(counter <=strlen(qinput))
                                                {
                                                    courseName[counter3] = qinput[counter];
                                                    counter ++;
                                                    counter3 ++;
                                                }



                                                lookup_query1(studentName,courseName,h1,h2);

                                           return 0;
                                          }


                                          int query2Ans(char* qinput,Hashtable h1, Hashtable h2, Hashtable h3, Hashtable h4){

                                                        char studentName[4096];
                                                        int counter = 9;
                                                        int counter2 =0;//name
                                                        int counter3 = 0;//time
                                                        int counter4 = 0;//day


                                                        while(1)
                                                        {

                                                            if(qinput[counter] == ' ' && qinput[counter+1] == 'a' && qinput[counter+2] == 't')
                                                            {
                                                                break;
                                                            }

                                                            else
                                                            {
                                                                studentName[counter2] = (char)qinput[counter];
                                                                counter++;
                                                                counter2++;

                                                            }
                                                        }
                                                        counter =counter+ 4;
                                                        char time[100];

                                                        while(1)
                                                        {
                                                            if(qinput[counter] == ' ' && qinput[counter+1] == 'o' && qinput[counter+2] == 'n')
                                                            {
                                                                break;
                                                            }
                                                            else
                                                            {

                                                                time[counter3] = qinput[counter];
                                                                counter++;
                                                                counter3++;

                                                            }
                                                        }
                                                        counter =counter+ 4;
                                                        char day[100];
                                                        while(counter< strlen(qinput) + 1)
                                                        {
                                                            day[counter4] =  qinput[counter];
                                                            counter ++;
                                                            counter4 ++;
                                                        }

                                                        lookup_query2(studentName,day,time,h1,h2,h3,h4);
                                                        return 0;

                                                    }
