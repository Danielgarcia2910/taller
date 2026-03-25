## Historia Usuario-01: Registrar cliente natural

**Como** cajero  
**Quiero** registrar un cliente natural con sus datos personales  
**Para** poder abrir una cuenta en el sistema  

### Criterios de aceptación:
- El documento de identidad no debe estar repetido  
- Los datos no pueden ser nulos o vacíos  
- El sistema lanza CapacidadExcedidaException si se supera el límite de clientes  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-02: Registrar cliente empresarial

**Como** cajero  
**Quiero** registrar un cliente empresarial con sus datos  
**Para** poder gestionar cuentas empresariales  

### Criterios de aceptación:
- El NIT no debe estar repetido  
- Los datos no pueden ser nulos o vacíos  
- Se valida la capacidad del banco  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-03: Abrir cuenta

**Como** cajero  
**Quiero** abrir una cuenta a un cliente  
**Para** permitirle realizar operaciones financieras  

### Criterios de aceptación:
- El cliente debe existir en el sistema  
- El cliente no puede tener más de 5 cuentas  
- Se valida la capacidad del banco  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-04: Realizar deposito

**Como** cajero  
**Quiero** realizar un deposito en una cuenta  
**Para** aumentar el saldo disponible  

### Criterios de aceptación:
- La cuenta no debe estar bloqueada  
- El monto debe ser positivo  
- Se actualiza el saldo correctamente  

### Prioridad:
Alta  

### Puntos:
3
## Historia de Usuario-05: Realizar retiro

**Como** cajero  
**Quiero** retirar dinero de una cuenta  
**Para** entregar efectivo al cliente  

### Criterios de aceptación:
- La cuenta no debe estar bloqueada  
- Debe haber saldo suficiente  
- Se lanza SaldoInsuficienteException si falla  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-06: Realizar transferencia

**Como** asesor financiero  
**Quiero** transferir dinero entre cuentas  
**Para** mover fondos entre clientes  

### Criterios de aceptación:
- Ambas cuentas deben existir  
- Se valida saldo suficiente  
- Se registra la transacción  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-07: Bloquear cuenta

**Como** asesor financiero  
**Quiero** bloquear una cuenta  
**Para** evitar operaciones por seguridad  

### Criterios de aceptación:
- La cuenta cambia a estado bloqueado  
- No permite depósitos ni retiros  

### Prioridad:
Media  

### Puntos:
3

## Historia de Usuario-08: Desbloquear cuenta

**Como** asesor financiero  
**Quiero** desbloquear una cuenta  
**Para** permitir operaciones nuevamente  

### Criterios de aceptación:
- La cuenta vuelve a estado activo  
- Permite operaciones nuevamente  

### Prioridad:
Media  

### Puntos:
3
## Historia de Usuario-09: Aprobar credito

**Como** gerente de sucursal  
**Quiero** aprobar un crédito  
**Para** autorizar financiamiento al cliente  

### Criterios de aceptación:
- Solo el gerente puede aprobar  
- Se lanza PermisoInsuficienteException si otro empleado intenta  

### Prioridad:
Alta  

### Puntos:
5
## Historia de Usuario-10: Registrar empleado

**Como** gerente de sucursal  
**Quiero** registrar empleados  
**Para** gestionar el personal del banco  

### Criterios de aceptación:
- Se valida la capacidad del banco  
- Los datos deben ser válidos  

### Prioridad:
Media  

### Puntos:
3

## Historia de Usuario-11: Calcular nomina

**Como** gerente de sucursal  
**Quiero** calcular la nómina total  
**Para** conocer los gastos del personal  

### Criterios de aceptación:
- Se suman los salarios de todos los empleados  
- Se usa polimorfismo  

### Prioridad:
Media  

### Puntos:
3

## Historia de Usuario-12: Recibir notificaciones

**Como** cliente  
**Quiero** recibir notificaciones  
**Para** estar informado de mis operaciones  

### Criterios de aceptación:
- Solo se envía si el cliente acepta notificaciones  
- Se muestra el mensaje en consola  

### Prioridad:
Media  

### Puntos:
2

## Historia de Usuario-13: Auditoria

**Como** sistema auditor  
**Quiero** consultar el historial de modificaciones  
**Para** verificar cambios en las entidades  

### Criterios de aceptación:
- Se registra fecha de modificación  
- Se registra usuario que modificó  
- Se puede consultar la información  

### Prioridad:
Media  

### Puntos:
3
