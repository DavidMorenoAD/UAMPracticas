/* Programa:    Multiplicación de matrices
*  Compilación: gcc multiMtcs.c
*  Ejecución:   ./a.out Amxn Bnxp m n p
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM_NOM 100

int * cargaMtz2D(char *nomArch, int m, int n);
void imprimeMtz2D(int *M,int m,int n);
void guardaMtz2D(char *nomArch, int *R, int m, int n);
int * mulMtcs(int *A, int *B, int m, int n, int p);

void main(int argc, char **argv)
{
    char *nomArchA;
    char *nomArchB;
    char *nomArchR;
    int m,n,p;
    int *A, *B, *R;

    if(argc != 6){
        printf("Error en el número de argumentos \n");
        printf("./a.out Amxn Bnxp m n p\n");
        exit(0);
    }

    nomArchA = (char *)calloc( TAM_NOM, sizeof(char) );
    nomArchB = (char *)calloc( TAM_NOM, sizeof(char) );
    nomArchR = (char *)calloc( TAM_NOM, sizeof(char) );

    strcpy(nomArchA,argv[1]);
    strcpy(nomArchB,argv[2]);
    m = atoi(argv[3]);
    n = atoi(argv[4]);
    p = atoi(argv[5]);
    sprintf(nomArchR,"R%dx%d",m,p);

    printf("****************\n");
    A = cargaMtz2D(nomArchA,m,n);
    imprimeMtz2D(A,m,n);

    printf("****************\n");
    B = cargaMtz2D(nomArchB,n,p);
    imprimeMtz2D(B,n,p);

    printf("****************\n");
    R = mulMtcs(A,B,m,n,p);
    imprimeMtz2D(R,m,p);  //Descomentar para ver el resultado

    guardaMtz2D(nomArchR,R,m,p);
}

int * mulMtcs(int *A, int *B, int m, int n, int p)
{
    int *arr;
    int k,i,j,ind,ind1,ind2;

    arr = (int *)malloc(m*p*sizeof(int));

   	for(i=0;i<m;i++)
	{
		for(j=0;j<p;j++)
		{
			arr[i*p+j]=0; //Acumulador de las sumas de multiplicaciones
			for(k=0;k<n;k++)
			{
				ind=i*p+j;
				ind1=i*n+k;//Indice de las filas
				ind2=k*p+j;//Indice de las columnas
				arr[ind]=arr[ind]+A[ind1]*B[ind2];
				ind1++;
			}
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
            ind = i*n+j;
            fprintf(apArch,"%d ",R[ind]);
        }
        fprintf(apArch,"\n");
    }
}


