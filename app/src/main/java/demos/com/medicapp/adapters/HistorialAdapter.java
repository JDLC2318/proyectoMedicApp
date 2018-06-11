package demos.com.medicapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demos.com.medicapp.R;
import demos.com.medicapp.model.Peso;

/**
 * Created by mayer on 09/06/2018.
 */

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder> {
    private final String TAG = "PelisAdapter";
    private List<Peso> mPesoList;
    private Context mContext;

    // TODO 5.1. Constructor del adapter @context, @listaHistorial
    public HistorialAdapter(Context context, List<Peso> list) {
        this.mPesoList = list;
        this.mContext = context;
    }

    @Override
    public HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mHistorialView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_registro_peso, parent, false);
        return new HistorialViewHolder(mHistorialView);
    }

    @Override
    public void onBindViewHolder(HistorialViewHolder holder, int position) {
        final Peso peso = mPesoList.get(position);
        holder.peso.setText("70");
        holder.imc.setText("25.4");
        holder.peso_menos.setText("-2 kg");
        holder.comentario.setText("mi comentario 2");
        holder.fecha.setText("09-06-2018");
    }

    @Override
    public int getItemCount() {
        return mPesoList.size();
    }


    class HistorialViewHolder extends RecyclerView.ViewHolder {
        // TODO 5.3. Creamos las referencias a nuestra vista con ButterKnife
        private final View mView;
        protected @BindView(R.id.peso)
        TextView peso;
        protected @BindView(R.id.imc)
        TextView imc;
        protected @BindView(R.id.fecha)
        TextView fecha;
        protected @BindView(R.id.peso_menos)
        TextView peso_menos;
        protected @BindView(R.id.comentario)
        TextView comentario;

        public HistorialViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this, itemView);
        }

        public View getmView() {
            return mView;
        }
    }
}
