# Regras de Negócio

 1. Não é permitido cadastro de artistas com nome repetido.
 2. Não é permitido cadastro de álbuns com nome repetido vinculado ao mesmo artista.
 3. Ao incluir um novo álbum de um artista, a lista deve ser atualizada, não sobrescrita.
 4.  O Sistema permite pesquisar todos os álbuns a partir do nome do artista.

# Tarefas

**Padrão CRUD**

 **- CREATE** 
Através do método POST, o sistema permitirá cadastrar um novo artista. Considerando as regras de negócio nº 1 e 2. Criar uma DTO de Entrada.

 **- READ**
 Através do método GET, o sistema permitirá exibir todos os artistas e pesquisar os álbuns de um artista específico. Criar uma DTO de Saída.  

**- UPDATE**
 Através do método PUT, o sistema permitirá atualizar a lista de álbuns de um artista específico.
Considerando as regras de negócio nº 3. Criar uma DTO Resumo.
 
 **- DELETE**
 Através do método DELETE, o sistema permitirá deletar um artista específico, usando o nome como parâmetro.

# Requisições:

### POST /artistas

    {
        "nome": "Ana Carolina",
        "genero": "MPB",
        "anoDeFundacao": "1995",
        "albuns": [
            {
                "nome": "Perfil",
                "ano": "2003",
                "gravadora": {
                    "nome": "Xablau Records"
                }
            }
        ] }

## Response

    {
    
    "nome":  "banda 1",
    
    "genero":  "MPB",
    
    "anoDeFundacao":  "1995",
    
    "albuns":  [
    
    {
    
    "id":  3,
    
    "nome":  "album1",
    
    "ano":  "2003",
    
    "gravadora":  {
    
    "id":  3,
    
    "nome":  "Gravadora Records"
    
			    }
    
		    }
    
	    ]
    
    }

## GET/artistas

      {  
     "nome": "Aerosmith"  
     },  
     {  
     "nome": "Beyonce"  
     } ,  
     {  
     "nome":
     "Bonde do Tigrão"  
     },  
     {  "nome": "Caetano Veloso"  
     }, 
     { 
     "nome":
     "Racionais MCS" 
     }, 
     { "nome": "Incubus" 
     }, 
     { 
     "nome": "RZO" 
     }, 
     { 
     "nome":
     "MC Bola de Fogo" 
     }
     , 
     { 
     "nome": "Anitta" 
     }, 
     {
      "nome": "Ana Carolina" 
      }

## GET/artistas/"nomeDaBanda"

    [
        {
            "nome": "Aerosmith",
            "albuns": [
                {
                    "id": 1,
                    "nome": "Pink",
                    "ano": "1989",
                    "gravadora": {
                        "id": 1,
                        "nome": "Xablau Records"
                    }
                }
            ]
        }
    ]



