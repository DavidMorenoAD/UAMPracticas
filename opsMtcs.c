/* Programa:    Operaciones con matrices
*  Compilación: gcc opsMtcs.c
*  Ejecución PARA SUMA:   ./a.out Amxn Bmxn m n
*/

/*Archivos de cabecera con la definición de funciones*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*Definición de constantes*/
#define TAM_NOM 100

/*Definición de variables globales*/
int varGlobal;

/*Declaración de funciones*/
int * cargaMtz2D(char *nomArch, int m, int n);
int * sumaMtcs(int *A, int *B, int m, int n);
void imprimeMtz2D(int *M,int m,int n);
void guardaMtz2D(char *nomArch, int *R, int m, int n);

/*Función principal, donde inicia el programa*/
void main(int argc, char **argv)
{
    /*Declaración de variables locales*/
    char *nomArchA;
    char *nomArchB;
    char *nomArchR;
    int m,n;
    int *A, *B, *R; //arreglos

    if(argc < 5){
        printf("Error en el número de argumentos \n");
        printf("./ops Amxn Bmxn m n\n");
        exit(0);
    }

    nomArchA = (char *)calloc( TAM_NOM, sizeof(char) );
    nomArchB = (char *)calloc( TAM_NOM, sizeof(char) );
    nomArchR = (char *)calloc( TAM_NOM, sizeof(char) );

    strcpy(nomArchA,argv[1]);
    strcpy(nomArchB,argv[2]);
    m = atoi(argv[3]);
    n = atoi(argv[4]);
    sprintf(nomArchR,"R%dx%d",m,n);
    //printf("%s + %s = %s de %dx%d \n", nomArchA, nomArchB, nomArchR, m, n);

    A = cargaMtz2D(nomArchA,m,n);
    printf("****************\n");
    imprimeMtz2D(A,m,n);

    B = cargaMtz2D(nomArchB,m,n);
    printf("****************\n");
    imprimeMtz2D(B,m,n);

    R = sumaMtcs(A,B,m,n);
    printf("****************\n");
    imprimeMtz2D(R,m,n);

    guardaMtz2D(nomArchR,R,m,n);
}

int * sumaMtcs(int *A, int *B, int m, int n)
{
    int *arr;
    int i,j,ind;

    arr = (int *)malloc(m*n*sizeof(int));

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            ind = i*n+j;
            arr[ind]=A[ind]+B[ind];
        }
    }

    return arr;
}

int * multiplicaMtcs(int *A, int *B, int m, int n)
{
    int *arr;
    int i,j,ind;

    arr = (int *)malloc(m*n*sizeof(int));

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            ind = i*n+j;
            arr[ind]=A[ind]+B[ind];
        }
    }

    return arr;
}

int * cargaMtz2D(char *nomArch, int m, int n)
{
    FILE *apArch;
    int i,j,ind;
    int *arr;

    if( (apArch=fopen(nomArch, "r")) == NULL ){
		printf("\n # IMPOSIBLE abrir el archivo: %s \n\n", nomArch);
		exit(0);
	}

    arr = (int *)malloc(m*n*sizeof(int));

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            ind = i*n+j;
            fscanf(apArch,"%d",&arr[ind]);
        }
    }

    return arr;
}

void imprimeMtz2D(int *M,int m,int n)
{
    int i,j,ind;

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            ind = i*n+j;
            printf("%d ",M[ind]);
        }
        printf("\n");
    }
}

void guardaMtz2D(char *nomArch, int *R, int m, int n)
{
    FILE *apArch;
    int i,j,ind;

    if( (apArch=fopen(nomArch, "w")) == NULL ){
		printf("\n # IMPOSIBLE abrir el archivo: %s \n\n", nomArch);
		exit(0);
	}

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            fprintf(apArch,"%d ",R[ind]);
        }
        fprintf(apArch,"\n");
    }
}


