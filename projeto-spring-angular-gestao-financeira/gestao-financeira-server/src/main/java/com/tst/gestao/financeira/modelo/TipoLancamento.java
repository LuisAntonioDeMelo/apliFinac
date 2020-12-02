package alga.server.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoLancamento {

    DESPESA("despesa"),
    RECEITA("receita");

    @Getter
    private final String descricao;

}
