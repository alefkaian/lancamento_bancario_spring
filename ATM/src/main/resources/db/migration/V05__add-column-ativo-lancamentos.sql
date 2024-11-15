alter table lancamentos add column ativo boolean;
update lancamentos set ativo = true;