package chl.ancud.m4_individual10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import chl.ancud.m4_individual10.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajeToast = verificaEntradas();

                if(mensajeToast.isEmpty()) {
                    mensajeToast = getString(R.string.toast_usuarioCreado);
                } else {
                    mensajeToast = getString(R.string.toast_faltanParametros) + mensajeToast;
                }

                Toast tostada = new Toast(getBaseContext());
                tostada.setText(mensajeToast);
                tostada.setDuration(Toast.LENGTH_SHORT);
                tostada.show();
            }
        });

    }

    private String verificaEntradas() {
        TextView eTx_nombre = binding.eTxNombre;
        TextView eTx_apellidos = binding.eTxApellidos;
        TextView eTx_correo = binding.eTxCorreo;
        TextView eTx_clave = binding.eTxClave;

        String nombre = "";
        String apellidos = "";
        String correo = "";
        String clave = "";

        Boolean pasaNoPasa = true;

        nombre = eTx_nombre.getText().toString();
        apellidos = eTx_apellidos.getText().toString();
        correo = eTx_correo.getText().toString();
        clave = eTx_clave.getText().toString();

        String mensajeToast = "";

        if(nombre.trim().isEmpty()){
            mensajeToast = getString(R.string.faltaNombre);
        }
        if(apellidos.trim().isEmpty()) {
            mensajeToast += ", " + getString(R.string.faltaApellidos);
        }
        if(correo.trim().isEmpty()) {
            mensajeToast += ", " + getString(R.string.faltaCorreo);
        }
        if(clave.trim().isEmpty()) {
            mensajeToast += ", " + getString(R.string.faltaClave);
        }

        return mensajeToast;
    }
}