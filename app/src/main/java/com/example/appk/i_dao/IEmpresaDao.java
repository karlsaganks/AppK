package com.example.appk.i_dao;

import com.example.appk.beans.Empresa;

import java.util.List;

public interface IEmpresaDao {
    public Empresa getEmpresaId(int id_empresa);
    public List<Empresa> getEmpresas();
    public Empresa primero();
    public Empresa ultimo();
    public boolean nuevo(Empresa e);
    public boolean eliminar(int id_empresa);
    public boolean actualizar(Empresa e);
}
