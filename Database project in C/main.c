#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#include "repl.h"
#include "Basic_op.h"
#include "Advanced_op.h"
#include "LinkedList.h"



        Tuple_snap snap1={12345, "C. Brown", "12 Apple St.", "555-1234"};
        Tuple_snap snap2={67890, "L. Van Pelt", "34 Pear Ave.", "555-5678"};
        Tuple_snap snap3={22222, "P. Patty", "56 Grape Blvd.", "555-9999"};

        Tuple_csg csg1={"CS101",12345,"A"};
        Tuple_csg csg2={"CS101",67890,"B"};
        Tuple_csg csg3={"EE200",12345,"C"};
        Tuple_csg csg4={"EE200",22222,"B+"};
        Tuple_csg csg5={"CS101",33333,"A-"};
        Tuple_csg csg6={"PH100",67890,"C+"};

        Tuple_cdh cdh1={"CS101", "M", "9AM"};
        Tuple_cdh cdh2={"CS101", "W", "9AM"};
        Tuple_cdh cdh3={"CS101", "F", "9AM"};
        Tuple_cdh cdh4={"EE200", "Tu", "10AM"};
        Tuple_cdh cdh5={"EE200", "W", "1PM"};
        Tuple_cdh cdh6={"EE200", "Th", "10AM"};

        Tuple_cr cr1={"CS101", "Turing Aud"};
        Tuple_cr cr2={"EE200", "25 Ohm Hall"};
        Tuple_cr cr3={"PH100", "Newton Lab"};

        Tuple_cp cp1={"CS101","CS100"};
        Tuple_cp cp2={"EE200","EE005"};
        Tuple_cp cp3={"EE200","CS100"};
        Tuple_cp cp4={"CS120","CS101"};
        Tuple_cp cp5={"CS121","CS120"};
        Tuple_cp cp6={"CS205","CS101"};
        Tuple_cp cp7={"CS206","CS121"};
        Tuple_cp cp8={"CS206","CS205"};


        Hashtable SNAP,CSG, CDH, CR, CP;

        void insert_using_methods(){


        insert_snap(snap1,SNAP);
        insert_snap(snap2, SNAP);
        insert_snap(snap3, SNAP);
       // print_snap(SNAP);
       // printf("insert_snapion complete \n");


        insert_csg(csg1, CSG);
        insert_csg(csg2, CSG);
        insert_csg(csg3, CSG);
        insert_csg(csg4, CSG);
        insert_csg(csg5, CSG);
        insert_csg(csg6, CSG);
       // print_csg(CSG);
        // printf("insert_csgion complete \n");


         insert_cdh(cdh1, CDH);
         insert_cdh(cdh2, CDH);
         insert_cdh(cdh3, CDH);
         insert_cdh(cdh4, CDH);
         insert_cdh(cdh5, CDH);
         insert_cdh(cdh6, CDH);
       // print_cdh(CDH);


        insert_cr(cr1, CR);
        insert_cr(cr2, CR);
        insert_cr(cr3, CR);
      // print_cr(CR);


        insert_cp(cp1, CP);
        insert_cp(cp2, CP);
        insert_cp(cp3, CP);
        insert_cp(cp4, CP);
        insert_cp(cp5, CP);
        insert_cp(cp6, CP);
        insert_cp(cp7, CP);
        insert_cp(cp8, CP);
       // print_cp(CP);

        }

        void reset(){

    for(int i=0; i<100; i++){
        SNAP[i]=new_LinkedList();
        }


        for(int i=0; i<100; i++){
        CSG[i]=new_LinkedList();
        }


        for(int i=0; i<100; i++){
        CDH[i]=new_LinkedList();
        }


        for(int i=0; i<100; i++){
        CR[i]=new_LinkedList();
        }


        for(int i=0; i<100; i++){
        CP[i]=new_LinkedList();
        }
        }


  void  write(){
    FILE *fp;
    fp = fopen("test.txt", "w+");
    fprintf(fp,"SNAP\n");
    fprintf(fp,"%d\t%s\t%s\t%s\t\n",  snap1.StudentId, snap1.Name, snap1.Address, snap1.Phone);
    fprintf(fp,"%d\t%s\t%s\t%s\t\n",  snap2.StudentId, snap2.Name, snap2.Address, snap2.Phone);
    fprintf(fp,"%d\t%s\t%s\t%s\t\n",  snap3.StudentId, snap3.Name, snap3.Address, snap3.Phone);
    fprintf(fp,"#\t#\t#\t#\t\n");
    fprintf(fp,"CSG\n");
    fprintf(fp,"%s\t%d\t%s\t\n",  csg1.Course,csg1.StudentId,csg1.Grade);
    fprintf(fp,"%s\t%d\t%s\t\n",  csg2.Course,csg2.StudentId,csg2.Grade);
    fprintf(fp,"%s\t%d\t%s\t\n",  csg3.Course,csg3.StudentId,csg3.Grade);
    fprintf(fp,"%s\t%d\t%s\t\n",  csg4.Course,csg4.StudentId,csg4.Grade);
    fprintf(fp,"%s\t%d\t%s\t\n",  csg5.Course,csg5.StudentId,csg5.Grade);
    fprintf(fp,"%s\t%d\t%s\t\n",  csg6.Course,csg6.StudentId,csg6.Grade);
    fprintf(fp,"#\t#\t#\t\n");
    fprintf(fp,"CDH\n");
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh1.Course,cdh1.Day,cdh1.Hour);
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh2.Course,cdh2.Day,cdh2.Hour);
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh3.Course,cdh3.Day,cdh3.Hour);
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh4.Course,cdh4.Day,cdh4.Hour);
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh5.Course,cdh5.Day,cdh5.Hour);
    fprintf(fp,"%s\t%s\t%s\t\n",  cdh6.Course,cdh6.Day,cdh6.Hour);
    fprintf(fp,"#\t#\t#\t\n");
    fprintf(fp,"CR\n");
    fprintf(fp,"%s\t%s\t\n",  cr1.Course, cr1.Room);
    fprintf(fp,"%s\t%s\t\n",  cr2.Course, cr2.Room);
    fprintf(fp,"%s\t%s\t\n",  cr3.Course, cr3.Room);
    fprintf(fp,"#\t#\t\n");
    fprintf(fp,"CP\n");
    fprintf(fp,"%s\t%s\t\n",  cp1.Course, cp1.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp2.Course, cp2.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp3.Course, cp3.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp4.Course, cp4.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp5.Course, cp5.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp6.Course, cp6.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp7.Course, cp7.Prereq);
    fprintf(fp,"%s\t%s\t\n",  cp8.Course, cp8.Prereq);
    fprintf(fp,"#\t#\t\n");
    fclose(fp);
}

    void read(){
    reset();
    FILE *fp1;
    char buff[255];
    fp1 = fopen("test.txt", "r");

    fscanf(fp1, "%s", buff);
    if(strcmp(buff,"SNAP")==0){
    char s[255];
    char n[255];
    char a[255];
    char p[255];

        while(true){
        Tuple_snap snapIns;
        fscanf( fp1, "%[^\t]\t%[^\t]\t%[^\t]\t%[^\t]\t\n",s,n,a,p);
        if(strcmp(s,"#")==0){
       // printf("Breaking Out");
        break;
        }


        const char *str = s;
        int x;
        sscanf(str, "%d", &x);

        snapIns.StudentId=x;
        strcpy(snapIns.Name,n);
        strcpy(snapIns.Address,a);
        strcpy(snapIns.Phone,p);
        insert_snap(snapIns,SNAP);
        }
    }

    fscanf(fp1, "%s", buff);
    if(strcmp(buff,"CSG")==0){
    fscanf(fp1, "\n");
    char c[255];
    char s[255];
    char g[255];

        while(true){
        Tuple_csg csgIns;
        fscanf( fp1, "%[^\t]\t%[^\t]\t%[^\t]\t\n",c,s,g);
        if(strcmp(c,"#")==0){
        //printf("Breaking Out\n");
        break;
        }
        const char *str = s;
        int x;
        sscanf(str, "%d", &x);

        csgIns.StudentId=x;
        strcpy(csgIns.Course,c);
        strcpy(csgIns.Grade,g);
        insert_csg(csgIns,CSG);
        }
    }


    fscanf(fp1, "%s", buff);
    if(strcmp(buff,"CDH")==0){
    fscanf(fp1, "\n");
    char c[255];
    char d[255];
    char h[255];

        while(true){
        Tuple_cdh Ins;
        fscanf( fp1, "%[^\t]\t%[^\t]\t%[^\t]\t\n",c,d,h);
        if(strcmp(c,"#")==0){
       // printf("Breaking Out\n");
        break;
        }



       strcpy(Ins.Course,c);
       strcpy(Ins.Day,d);
       strcpy(Ins.Hour,h);
       insert_cdh(Ins,CDH);
        }
    }

    fscanf(fp1, "%s", buff);
    if(strcmp(buff,"CR")==0){
    fscanf(fp1, "\n");
    char c[255];
    char r[255];


        while(true){
        Tuple_cr Ins;
        fscanf( fp1, "%[^\t]\t%[^\t]\t\n",c,r);
        if(strcmp(c,"#")==0){
        //printf("Breaking Out\n");
        break;
        }
        strcpy(Ins.Course,c);
       strcpy(Ins.Room,r);
       insert_cr(Ins,CR);
        }
    }

    fscanf(fp1, "%s", buff);
    if(strcmp(buff,"CP")==0){
    fscanf(fp1, "\n");
    char c[255];
    char p[255];


        while(true){
        Tuple_cp Ins;
        fscanf( fp1, "%[^\t]\t%[^\t]\t\n",c,p);
        if(strcmp(c,"#")==0){
       // printf("Breaking Out\n");
        break;
        }
       strcpy(Ins.Course,c);
       strcpy(Ins.Prereq,p);
       insert_cp(Ins,CP);
        }
    }
    fclose(fp1);
}



void printall(){
        printf("\tSNAP\n");
        print_snap(SNAP);

        printf("\tCSG\n");
        print_csg(CSG);


        printf("\tCDH\n");
        print_cdh(CDH);


        printf("\tCR\n");
        print_cr(CR);


        printf("\tCP\n");
        print_cp(CP);
}




        int main(){

            printf("\t\tPART I\n");
            while(true){
            char input[50];
            printf("Please chose an input to create the databases (1: to start 0: quit)\n");
            fgets(input, 50, stdin);    //Gets user input
            input [strlen(input) - 1] = '\0';   //Replaces newline in input with an end of string character
            if (strcmp(input, "1") == 0){
                reset();
                insert_using_methods();
                printf("All databases have been created.\n");
                printall();

                break;
            } else if( strcmp(input,"0")==0){
                printf("END");
                exit(1);
            }else{
            printf("Input not defined, try again!\n");
            continue;
            }
            }

            while(true){
            char input[50];
            printf("Please chose an input to write the databases on a file (0: quit,1: to start,2:skip)\n");
            fgets(input, 50, stdin);    //Gets user input
            input [strlen(input) - 1] = '\0';   //Replaces newline in input with an end of string character
            if (strcmp(input, "1") == 0){
             write();
             printf("A test.txt file has been created.\n");
                break;
            } else if( strcmp(input,"0")==0){
                printf("END");
                exit(1);
            }else if( strcmp(input,"2")==0){
            printf("Skipped\n");
                break;
            }else{
            printf("Input not defined, try again!\n");
            continue;
            }
            }

            while(true){
            char input[50];
            printf("Please chose an input to read the databases on a file (0: quit,1: to start,2:skip)\n");
            fgets(input, 50, stdin);    //Gets user input
            input [strlen(input) - 1] = '\0';   //Replaces newline in input with an end of string character
            if (strcmp(input, "1") == 0){
             read();
             printall();
                break;
            } else if( strcmp(input,"0")==0){
                printf("END");
                exit(1);
            }else if( strcmp(input,"2")==0){
            printf("Skipped");
                break;
            }else{
            printf("Input not defined, try again!\n");
            continue;
            }
            }

            while(true){
            char input[50];
            printf("Please chose an input to see the demonstration of the basic relational operations (0: quit,1: to start,2:skip)\n");
            fgets(input, 50, stdin);    //Gets user input
            input [strlen(input) - 1] = '\0';   //Replaces newline in input with an end of string character
            if (strcmp(input, "1") == 0){
            printf("\n\n\n\n\n\n\n\n\n\n\n\n");

        printf("Deleting all records with studentID= 22222\n");
        delete_snap("22222","*", "*", "*", SNAP);
        printf("Deletion Complete \n");
        printf("Deleting all records with name= C.Brown");
        delete_snap("*","C. Brown", "*", "*", SNAP);
        printf("Deletion Complete!\n");
        print_snap(SNAP);
        printf("\n\n\n");
        reset();
        insert_using_methods();//resetting the values;


        printf("Looking for courses held in Newton Lab\n");
        lookup_cr("*","Newton Lab",CR);
        printf("Lookup Complete!\n") ;


                break;
            } else if( strcmp(input,"0")==0){
                printf("END");
                exit(1);
            }else if( strcmp(input,"2")==0){
            printf("Skipped");
                break;
            }else{
            printf("Input not defined, try again!\n");
            continue;
            }
            }






            reset();
            insert_using_methods();

            while(true){
            printf("\n\n\t\tPART II\n");
            query1(SNAP,CSG);
            query2(SNAP,CSG,CDH,CR);

            char input[50];
            printf("Please chose an input to try again (1:try again 0: next)\n");
            fgets(input, 50, stdin);    //Gets user input
            input [strlen(input) - 1] = '\0';   //Replaces newline in input with an end of string character
            if (strcmp(input, "1") == 0){
                continue;
            } else if( strcmp(input,"0")==0){
                break;

            }
            }




        //resets hashtables that already exists and then recreates them



        printf("\t\t\tPART III");

       printf("Selecting a given course(CS101) from CSG:\n");
       Hashtable Selection_CSG;
       select_CSG("CS101", CSG,Selection_CSG);
       print_csg(Selection_CSG);


       printf("\nProjecting the studentId out of previously selected records:\n");
       Hashtable Projection_CSG;
       project_CSG("StudentId",Selection_CSG,Projection_CSG);
       print_gen(Projection_CSG);

        printf("Joining the CDH and CR database\n");
       Hashtable Join_CDH_CR;
       join_CDH_CR(CDH,CR,Join_CDH_CR);
        printf("\nPrinting crdh\n");
        print_crdh(Join_CDH_CR);

        printf("\nSelecting on the Joined Relationship\n");
        Hashtable Select_On_Join_CDH_CR;
        select_CRDH("Turing Aud",Join_CDH_CR,Select_On_Join_CDH_CR);
        print_crdh(Select_On_Join_CDH_CR);


        printf("Projecting from the previous selection on the join \n");
        Hashtable projected_CR;
        project_CR(Select_On_Join_CDH_CR, projected_CR);



       return 0;


    }












