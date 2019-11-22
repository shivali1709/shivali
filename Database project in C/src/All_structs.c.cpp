
    typedef struct Tuple_snap {
        int StudentId;
        char Name[30];
        char Address[50];
        char Phone[64];
    } Tuple_snap;

    typedef struct Tuple_crdh{
        char Course[32];
        char Room[128];
        char Day[8];
        char Hour[16];

    }Tuple_crdh;


    typedef struct Tuple_csg {
        char Course[32];
        int StudentId;
        char Grade[8];
    } Tuple_csg;

    typedef struct Tuple_cdh {
        char Course[32];
        char Day[8];
        char Hour[16];
    }Tuple_cdh;

    typedef struct Tuple_cp {
        char Course[32];
        char Prereq[32];
    } Tuple_cp;


    typedef struct Tuple_cr {
        char Course[32];
        char Room[128];
    } Tuple_cr;

    typedef struct Tuple_gen {
        char Property[32];

    }Tuple_gen;
