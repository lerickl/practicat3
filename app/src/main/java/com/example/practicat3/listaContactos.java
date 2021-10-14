package com.example.practicat3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicat3.models.contacto;

import java.util.List;

public class listaContactos extends RecyclerView.Adapter<listaContactos.StringViewHolder>{
    private List<contacto> mData;
    private View view;
    private Button Llamar;
    private Button sms;
    public listaContactos(List<contacto> getcontacto) {
        mData=getcontacto;

    }

    public class StringViewHolder extends RecyclerView.ViewHolder {
        private View mview;
        public StringViewHolder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;
        }
    }
    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
        View view= mLayoutInflater.inflate(R.layout.item_contact, parent , false);
        return new StringViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, int position) {
        //lleno los datos

        TextView mTextViewNombre = holder.mview.findViewById(R.id.txtnombre);
        TextView mTextViewDescripcion = holder.mview.findViewById(R.id.txtnumero);


        contacto text=mData.get(position);

        mTextViewNombre.setText(text.names);
        mTextViewDescripcion.setText(text.phone);
        Button btnCliCk = holder.itemView.findViewById(R.id.btnllamar);
        btnCliCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+text.phone));

                holder.itemView.getContext().startActivity(i);
            }
        });

        Button btnCliCk1 = holder.itemView.findViewById(R.id.btnsms);
        btnCliCk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+text.phone));


                i.putExtra("sms_body", "mensaje");


                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    public void sms(final int pos){
        Llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                contacto contactos = mData.get(pos);
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("tel:"+mData.get(pos).phone));
                context.startActivity(i);

            }
        });
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

}
