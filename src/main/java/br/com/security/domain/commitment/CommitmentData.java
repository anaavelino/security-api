package br.com.security.domain.commitment;

import java.util.Date;

public record CommitmentData(Long idUser, String title, String descript, Date dateStart, Date dateFinish, Boolean finish) {

}
