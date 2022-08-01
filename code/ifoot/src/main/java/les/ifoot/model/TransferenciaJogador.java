package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class TransferenciaJogador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A data em que a transferencia do jogador foi aplicada deve ser preenchida")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String data_transferencia;

	@Min(value = 1, message = "Valor da transferencia do jogador deve ser maior que zero")
	@NotNull(message = "Valor da transferencia do jogador deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor da transferencia do jogador deve ser preenchido com dígitos")
	private Double valor;

	@NotNull(message = "O jogador remetente em transferencia de dinheiro deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_remetente_id")
	private Jogador jogador_remetente;

	@NotNull(message = "O jogador destinatário em transferencia de dinheiro deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "jogador_destinatario_id")
	private Jogador jogador_destinatario;

}
