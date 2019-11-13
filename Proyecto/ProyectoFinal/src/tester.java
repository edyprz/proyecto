import java.util.*;

public class tester {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Serializacion util = new Serializacion();
		
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		List<Ayudante> listaAyudante = new ArrayList<Ayudante>();
		List<Visitante> listaVisitante = new ArrayList<Visitante>();
		List<UEA> listaUea = new ArrayList<UEA>();
		List<Salon> listaSalon = new ArrayList<Salon>();
		List<Horario> listaHorario = new ArrayList<Horario>();
		
		listaAlumno = util.deserializaLista("alumno.ser");
		listaProfesor = util.deserializaLista("profesor.ser");
		listaAyudante = util.deserializaLista("ayudante.ser");
		listaVisitante = util.deserializaLista("visitante.ser");
		listaUea = util.deserializaLista("uea.ser");
		listaSalon = util.deserializaLista("salon.ser");
		listaHorario = util.deserializaLista("horario.ser");
		
		String opcion;
		do{
			menuprincipal();
			opcion = scan.nextLine();
			
			switch(opcion) {
                case "1": // Alta de registro
                	String alta;
                	do {
                		desplegarRegistros("dar de alta");
                        alta = scan.nextLine();
                        
                        switch(alta) {
                            case "1": // alumno
                            	Alumno a = new Alumno();
                            	a.registro();
                            	if (listaAlumno == null) listaAlumno = new ArrayList<Alumno>();
                            	listaAlumno.add(a);
                                break;
                            case "2": // profesor
                            	Profesor p = new Profesor();
                            	p.registro(); p.registroEmpleado();
                            	if (listaProfesor == null) listaProfesor = new ArrayList<Profesor>();
                            	listaProfesor.add(p);
                                break;
                            case "3": // ayudante
                            	Ayudante ayu = new Ayudante();
                            	ayu.registro(); ayu.registroEmpleado();
                            	if (listaAyudante == null) listaAyudante = new ArrayList<Ayudante>();
                            	listaAyudante.add(ayu);
                                break;
                            case "4": // Visitante
                            	Visitante v = new Visitante();
                            	v.registro();
                            	if (listaVisitante == null) listaVisitante = new ArrayList<Visitante>();
                            	listaVisitante.add(v);
                                break;
                            case "5": // Salon
                            	Salon s = new Salon();
                            	s.registro();
                            	if (listaSalon == null) listaSalon = new ArrayList<Salon>();
                                listaSalon.add(s); 
                                break;
                            case "6": // UEA
                                UEA uea = new UEA();
                                uea.registro();
                                if (listaUea == null) listaUea = new ArrayList<UEA>();
                                listaUea.add(uea);                               
                                break;
                            case "7": // horario
                            	if (!(listaProfesor.isEmpty() && listaUea.isEmpty() && listaSalon.isEmpty())) {
	                            	System.out.println("Maestros disponibles:"); iterar(listaProfesor);
	                            	System.out.println("Salones disponibles:"); iterar(listaSalon);
	                            	System.out.println("UEAs disponibles:"); iterar(listaUea);
	                            	Horario h = new Horario();
	                                h.registro();
	                                if (listaHorario == null) listaHorario = new ArrayList<Horario>();
	                                listaHorario.add(h); 
                            	} else System.out.println("Lista de profesores y/o ueas y/o salones esta vacia");
                                break;
                            default: break;
                        }//switch
                        
                    } while (!(alta.equalsIgnoreCase("8"))); break;
                    
                case "2": //Eliminacion de registro
                	String eliminar;
                	do {
                		desplegarRegistros("eliminar");
                        eliminar = scan.nextLine();
                        
                        switch(eliminar) {
                            case "1":// alumno
                            	if (listaAlumno != null) {
	                                System.out.println("Dame la matricula");
	                                String mat = scan.nextLine();
	                                Alumno a = Alumno.getAlumno(listaAlumno, mat);
	                                if (a != null) listaAlumno.remove(a);
	                                else System.out.println("Lista de alumnos esta vacia o la matricula es incorrecta");
                            	} else System.out.println("Lista de alumnos esta vacia");
                                break;    
                            case "2": // profesor
                            	if (listaProfesor != null) {
	                                System.out.println("Dame el numero economico");
	                                String num = scan.nextLine();
	                                Profesor p = Profesor.getProfesor(listaProfesor, num);
	                                if (p != null) listaProfesor.remove(p);
	                                else System.out.println("Lista de profesores esta vacia o el numero economico es incorrecta");
                            	} else System.out.println("Lista de profesores esta vacia");
                                break;
                            case "3": // ayudante
	                            if (listaAyudante != null) {	
                            		System.out.println("Quieres eliminar por matricula o numero economico");
	                            	String dE = scan.nextLine();
	                            	Ayudante ayu = null;
	                            	if(dE.equalsIgnoreCase("matricula")) {
	                            		System.out.println("Dame la matricula");
	                            		String eMat = scan.nextLine();
	                            		ayu = Ayudante.getAyudante(listaAyudante, eMat, dE);
	                            	} else if(dE.equalsIgnoreCase("numero Economico")) {
	                            		System.out.println("Dame el numero economico");
	                            		String eNum = scan.nextLine();
	                            		ayu = Ayudante.getAyudante(listaAyudante, eNum, dE);
	                            	}
	                            	if (ayu != null) listaAyudante.remove(ayu);
	                            	else System.out.println("Lista de ayudantes esta vacia o el numero economico/matricula es incorrecta");
	                            } else System.out.println("Lista de ayudantes esta vacia");
	                            break;
                            case "4": // visitante
                            	if (listaAyudante != null) {
	                            	System.out.println("Dame el nombre");
	                                String nom = scan.nextLine();
	                                Visitante v = Visitante.getVisitante(listaVisitante, nom);
	                                if (v != null) listaVisitante.remove(v);
	                                else System.out.println("Lista de visitantes esta vacia o el nombre es incorrecto");
                            	} else System.out.println("Lista de visitantes esta vacia");
                                break;
                            case "5": // salon
                            	if (listaSalon != null) {
	                            	System.out.println("Dame el salon");
	                                String sal = scan.nextLine();
	                                Salon s = Salon.getSalon(listaSalon, sal);
	                                if (s != null) listaSalon.remove(s);
	                                else System.out.println("Lista de salones esta vacia o el salon es incorrecto");
                            	} else System.out.println("Lista de salones esta vacia");
                                break;
                            case "6": // uea
                            	if (listaUea != null) {
	                            	System.out.println("Dame la clave");
	                                String cla = scan.nextLine();
	                                UEA uea = UEA.getUEA(listaUea, cla);
	                                if (uea != null) listaUea.remove(uea);
	                                else System.out.println("Lista de UEAs esta vacia o la uea es incorrecta");
                            	} else System.out.println("Lista de UEAs esta vacia");
                                break;
                            case "7": // horario
                            	if (listaHorario != null) {
	                            	System.out.println("Dame la clave");
	                                String hor = scan.nextLine();
	                                Horario h = Horario.getHorario(listaHorario, hor);
	                                if (h != null) listaHorario.remove(h);
	                                else System.out.println("Lista de horarios esta vacia o el horario es incorrecta");
                            	} else System.out.println("Lista de horarios esta vacia");
                            	break;
                            default: break;
                        }//switch end
                        
                    } while (!(eliminar.equalsIgnoreCase("8"))); break;
                    
                case "3": //Modificaion de registro
                    String modificar;
                    do {
                    	desplegarRegistros("modificar");
                        modificar = scan.nextLine();
                        
                        switch(modificar) {
	                        case "1":// alumno
	                        	if (listaAlumno != null) {
		                        	System.out.println("Dame la matricula");
			                        String mat = scan.nextLine();
			                        Alumno aMod = Alumno.getAlumno(listaAlumno, mat);
			                        if (aMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	Alumno actualiza = new Alumno();
			                           	actualiza.registro();
			                           	listaAlumno.set(listaAlumno.indexOf(aMod), actualiza);
			                        }
		                        } else System.out.println("Lista de alumnos esta vacia");
	                        	break;    
	                        case "2": // profesor
	                        	if (listaProfesor != null) {
		                        	System.out.println("Dame el numero economico");
			                        String num = scan.nextLine();
			                        Profesor pMod = Profesor.getProfesor(listaProfesor, num);
			                        if (pMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	Profesor actualiza = new Profesor();
			                           	actualiza.registro(); actualiza.registroEmpleado();
			                           	listaProfesor.set(listaProfesor.indexOf(pMod), actualiza);
			                        }
		                        } break;
	                        case "3": // ayudante
	                        	if (listaAyudante != null) {
		                        	System.out.println("Quieres modificar por matricula o numero economico");
	                            	String dM = scan.nextLine();
	                            	Ayudante ayuMod = null;
	                            	if(dM.equalsIgnoreCase("matricula")) {
	                            		System.out.println("Dame la matricula");
	                            		String mMat = scan.nextLine();
	                            		ayuMod = Ayudante.getAyudante(listaAyudante, mMat, dM);
	                            	} else if(dM.equalsIgnoreCase("numero Economico")) {
	                            		System.out.println("Dame el numero Economico");
	                            		String mNum = scan.nextLine();
	                            		ayuMod = Ayudante.getAyudante(listaAyudante, mNum, dM);
	                            	}
	    		                    if (ayuMod != null) {
	    		                    	System.out.println("Nuevos datos");
	    		                        Ayudante actualiza = new Ayudante();
	    		                        actualiza.registro(); actualiza.registroEmpleado();
	    		                        listaAyudante.set(listaAyudante.indexOf(ayuMod), actualiza);
	    		                    }
    		                    } break;
	                        case "4": // visitante
	                        	if (listaVisitante != null) {
		                        	System.out.println("Dame el nombre");
		                            String nom = scan.nextLine();
		                            Visitante vMod = Visitante.getVisitante(listaVisitante, nom);
			                        if (vMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	Visitante actualiza = new Visitante();
			                           	actualiza.registro();
			                           	listaVisitante.set(listaVisitante.indexOf(vMod), actualiza);
			                        }
		                        } break;
	                        case "5": // salon
	                        	if (listaSalon != null) {
		                        	System.out.println("Dame el salon");
		                            String sal = scan.nextLine();
		                            Salon sMod = Salon.getSalon(listaSalon, sal);
			                        if (sMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	Salon actualiza = new Salon();
			                           	actualiza.registro();
			                           	listaSalon.set(listaSalon.indexOf(sMod), actualiza);
			                        }
		                        } break;
	                        case "6": // uea
	                        	if (listaUea != null) {
		                        	System.out.println("Dame la clave");
		                            String cla = scan.nextLine();
		                            UEA ueaMod = UEA.getUEA(listaUea, cla);
			                        if (ueaMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	UEA actualiza = new UEA();
			                           	actualiza.registro();
			                           	listaUea.set(listaUea.indexOf(ueaMod), actualiza);
			                        }
		                        } break;
	                        case "7": // horario
	                        	if (listaHorario != null) {
		                        	System.out.println("Dame la clave");
		                            String hor = scan.nextLine();
		                            Horario hMod = Horario.getHorario(listaHorario, hor);
			                        if (hMod != null) {
			                          	System.out.println("Nuevos datos");
			                           	Horario actualiza = new Horario();
			                           	actualiza.registro();
			                           	listaHorario.set(listaHorario.indexOf(hMod), actualiza);
			                        }
		                        } break;
	                        default: break;
                        } // switch ends
                        
                    } while(!(modificar.equalsIgnoreCase("8"))); break;
                    
                case "4": //consulta de registo
                	String consulta;
                    do {
                    	desplegarRegistros("consultar");
                        consulta = scan.nextLine();
                        
                        switch(consulta) {
                            case "1": // alumno
                            	if (listaAlumno != null) iterar(listaAlumno); break;
                            case "2": // profesor
                            	if (listaProfesor != null) iterar(listaProfesor); break;
                            case "3": // ayudante
                            	if (listaAyudante != null) iterar(listaAyudante); break;
                            case "4": // visitante
                            	if (listaVisitante != null) iterar(listaVisitante); break;
                            case "5": // salon
                            	if (listaSalon != null) iterar(listaSalon); break;
                            case "6": // uea
                            	if (listaUea != null) iterar(listaUea); break;
                            case "7": // horario
                            	if (listaHorario != null) iterar(listaHorario); break;
                            default: break;
                        }//switch
                        
                    } while (!(consulta.equalsIgnoreCase("8"))); break;
                
                case "5": // Agregar horario a alumno
                	if (listaHorario != null) {
	                	if (!(listaHorario.isEmpty())) {
	                    	System.out.println("Horarios disponibles:"); iterar(listaHorario);
		                	System.out.println("Dame la matricula");
		                    String mat = scan.nextLine();
		                    Alumno hAlumno = Alumno.getAlumno(listaAlumno, mat);
		                    if (hAlumno != null) {
		                      	System.out.println("Dame clave del horario");
		                      	String claH = scan.nextLine();
		                      	Horario h = Horario.getHorario(listaHorario, claH);
		                       	if (h != null) hAlumno.getHorario().add(h);
		                       	else System.out.println("Clave de horario es incorrecta o no esta registrada");
		                    } else System.out.println("Matricula es incorrecta o no esta registrada");
	                	} else System.out.println("Lista de horarios esta vacia");
                	} break;
                	
                case "6": // Serializar y Salir
                    util.serializaLista("alumno.ser", listaAlumno);
                	util.serializaLista("profesor.ser", listaProfesor);
                	util.serializaLista("ayudante.ser", listaAyudante);
                	util.serializaLista("visitante.ser", listaVisitante);
                	util.serializaLista("uea.ser", listaUea);
                	util.serializaLista("salon.ser", listaSalon);
                	util.serializaLista("horario.ser", listaHorario);
                	break;
                	
                default: break;
            }
			
        } while(!(opcion.equalsIgnoreCase("6"))); 
		scan.close();
	}//llave main
    
    // funciones externas
	public static <E> void iterar(List<E> lista) {
		Iterator<E> iter = lista.iterator();
		while (iter.hasNext()) 
			System.out.println(iter.next().toString());
	}
	
	public static void desplegarRegistros(String accion) {
		System.out.println("\nQue quiere "+accion+"?:"+
							"\n1. Alumno" +
			                "\n2. Profesor" + 
			                "\n3. Ayudante"+
			                "\n4. Visitante" +
			                "\n5. Salon" + 
			                "\n6. UEA" + 
			                "\n7. Horario"+
			                "\n8. Salir");
	}
	
    public static void menuprincipal(){
        System.out.println("\nQue quiere realizar?" +
						    "\n1. Alta de registro" +
			                "\n2. Eliminacion de registro" +
							"\n3. Modificacion de registro" + 
							"\n4. Consulta de registro" + 
							"\n5. Agregar horario a alumno"+
							"\n6. Salir");
    }
}
