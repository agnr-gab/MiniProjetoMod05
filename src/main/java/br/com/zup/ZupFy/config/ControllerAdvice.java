package br.com.zup.ZupFy.config;

import br.com.zup.ZupFy.exceptions.CadastroExistenteException;
import br.com.zup.ZupFy.exceptions.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro idNaoEncontradoException(IdNaoEncontradoException excecao) {
        return new MensagemDeErro(excecao.getLocalizedMessage());
    }

    @ExceptionHandler(CadastroExistenteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro cadastroExistenteException(CadastroExistenteException excecao) {
        return new MensagemDeErro(excecao.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularErrosDeSintaxe(MethodArgumentNotValidException exception) {
        List<MensagemDeErro> listaDeErros = new ArrayList<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemDeErro mensagemDeErro = new MensagemDeErro(fieldError.getDefaultMessage());
            listaDeErros.add(mensagemDeErro);
        }
        return listaDeErros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro enumInvalidoException(HttpMessageNotReadableException excecao) {
        return new MensagemDeErro(excecao.getLocalizedMessage());
    }

}