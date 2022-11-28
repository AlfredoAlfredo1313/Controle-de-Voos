INSERT INTO aerovia (id, ponto_de_partida, ponto_de_chegada, distancia) VALUES ('av1', 'Porto Alegre - Salgado Filho', 'Sao Paulo - Congonhas', 5000.5)
//INSERT INTO aerovia (id, ponto_de_partida, ponto_de_chegada, distancia) VALUES ('av2', 'Porto Alegre - Salgado Filho', 'Sao Paulo - Congonhas', 5050.9)
//INSERT INTO aerovia (id, ponto_de_partida, ponto_de_chegada, distancia) VALUES ('av3', 'Porto Alegre - Salgado Filho', 'P1', 2500.5)
//INSERT INTO aerovia (id, ponto_de_partida, ponto_de_chegada, distancia) VALUES ('av4', 'P1', 'Sao Paulo - Congonhas', 4900.5)
INSERT INTO aerovia (id, ponto_de_partida, ponto_de_chegada, distancia) VALUES ('av5', 'Porto Alegre - Salgado Filho', 'Buenos Aires', 1500.5)


INSERT INTO timeslot (aerovia_id, data, time_slots) VALUES ('av1', '280309', '0,2,1,1,0,0,0,0,0,0')
INSERT INTO timeslot (data, time_slots) VALUES ('120318', '0,0,0,0,0,0,0,0,0,0')

INSERT INTO rota (partida, chegada) VALUES ('Salgado Filho', 'Congonhas')
//INSERT INTO rota (partida, chegada) VALUES ('Salgado Filho', 'Congonhas')
//INSERT INTO rota (partida, chegada) VALUES ('Salgado Filho', 'Congonhas')
INSERT INTO rota (partida, chegada) VALUES ('Salgado Filho', 'Buenos Aires')

INSERT INTO ROTA_AEROVIA (aerovia_id, rota_id) VALUES ('av1', 1)
//INSERT INTO ROTA_AEROVIA (aerovia_id, rota_id) VALUES ('av2', 2)
//INSERT INTO ROTA_AEROVIA (aerovia_id, rota_id) VALUES ('av3', 3)
//INSERT INTO ROTA_AEROVIA (aerovia_id, rota_id) VALUES ('av4', 3)
//INSERT INTO ROTA_AEROVIA (aerovia_id, rota_id) VALUES ('av5', 4)

