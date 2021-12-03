# UML - Linguagem Unificada de Modelagem - Diagrama
![enter image description here](https://i.ibb.co/m5gfPXR/ZupFy.png)
# Regras de Negócio

 - [x] Não é permitido cadastro de artistas com nome repetido.
 - [x] Não é permitido cadastro de álbuns com nome repetido vinculado ao  mesmo artista.
 - [x] Ao incluir um novo álbum de um artista, a lista deve ser
       atualizada, não sobrescrita.
 - [x] O Sistema permite pesquisar todos os álbuns a partir do id do
       artista.

# Tarefas

**Padrão CRUD**

 **- CREATE** 
Através do método POST, o sistema permitirá cadastrar um novo artista. Considerando as regras de negócio nº 1 e 2. 

 **- READ**
 Através do método GET, o sistema permitirá exibir todos os artistas e também pesquisar os álbuns de um artista específico. 

**- UPDATE**
 Através do método PUT, o sistema permitirá atualizar a lista de álbuns de um artista específico. 
 
 **- DELETE**
 Através do método DELETE, o sistema permitirá deletar um artista específico, usando o id como parâmetro.

# Requisições:

### POST 

Endpoint: /artistas 
Response Status 201

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
            ] 
            }

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


## GET
Endpoint: /artistas 


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

## GET
Endpoint: /artistas/{id}

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
## POST
Endpoint:/albuns
*Response Status 201*

    {  "ano":  "2010",  
	    "gravadora":  {  
		    "id":  0,  
		    "nome":  "string"  
    },  
	    "id":  0,  
	    "nome":  "string"  
    }

## PUT
Endpoint: /albuns/{id}

    { 
    "id": 3, 
    "nome": "Formation", 
    "ano": "2016", 
    "gravadora": 
	    { 
	    "id": 3, 
	    "nome": "Def jam Records" 
		    } 
	    }

## DELETE
Endpoint: /artistas/{id}
*Response Status 204*

## Lista de Pendências

 - Permitir cadastro de um álbum existente (com o mesmo nome), mas para artistas diferentes.
 - Refatorar os métodos que não estão de acordo com o principio da responsabilidade única (Single Responsibility Principle).
 - Considerar mais exceções através de testes mais específicos.
 - Cadastrar gravadora quando um álbum for atualizado.
 - Repensar lógica da exceção "cadastro existente exception", pois não está funcionando corretamente. 
 
