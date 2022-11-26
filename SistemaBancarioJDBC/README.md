CREATE TABLE IF NOT EXISTS log(
	id SERIAL PRIMARY KEY,
	data DATE DEFAULT NOW(),
	operacao VARCHAR(120) NOT NULL,
	numero_conta_origem VARCHAR(10) NOT NULL,
	numero_conta_destino VARCHAR(10)
);