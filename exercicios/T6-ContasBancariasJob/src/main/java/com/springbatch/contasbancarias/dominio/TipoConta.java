package com.springbatch.contasbancarias.dominio;

public enum TipoConta {
	PRATA, OURO, PLATINA, DIAMANTE;
	
	public static TipoConta fromFaixaSalarial(double faixaSalarial) {
		if (faixaSalarial <= 3000)
			return PRATA;
		else if (faixaSalarial > 3000 && faixaSalarial <= 5000)
			return OURO;
		else if (faixaSalarial > 5000 && faixaSalarial <= 10000)
			return PLATINA;
		else
			return DIAMANTE;
	}
}
