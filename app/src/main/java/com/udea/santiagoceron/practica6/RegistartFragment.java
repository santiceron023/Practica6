package com.udea.santiagoceron.practica6;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistartFragment extends Fragment {

    private EditText eLibro, eAutor, eTelefono, ePersona;
    private String libro, persona, autor, telefono;
    private Button bAdd;
    private LibrosSQLiteHelper libros;
    private SQLiteDatabase dbLibros;



    public RegistartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registart, container, false);

        eLibro = (EditText)view.findViewById(R.id.eLibro);
        eAutor = (EditText)view.findViewById(R.id.eAutor);
        ePersona = (EditText)view.findViewById(R.id.ePersona);
        eTelefono = (EditText)view.findViewById(R.id.eTelefono);
        bAdd = (Button)view.findViewById(R.id.bAdd);


        libros = new LibrosSQLiteHelper(getContext(), "LibrosDB", null,1);
        dbLibros=libros.getWritableDatabase();



        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                libro   =   eLibro.getText().toString();
                autor   =   eAutor.getText().toString();
                persona =    ePersona.getText().toString();
                telefono=   eTelefono.getText().toString();

                if(libro.isEmpty()||autor.isEmpty()||persona.isEmpty()||telefono.isEmpty()){
                    Toast.makeText(getContext(),"Complete todos los datos",Toast.LENGTH_SHORT).show();
                }else{
                    ContentValues data = new ContentValues();
                    data.put("libro", libro);
                    data.put("autor",autor);
                    data.put("persona", persona);
                    data.put("telefono", telefono);

                    dbLibros.insert("Libros",null,data);

                    //Toast.makeText(getContext(),persona,Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }


}
