import { Type } from "./Type";


// Generated by https://quicktype.io

export interface IKmeansResult {
    clusters: Cluster[];
}

export interface Cluster {
    puntos: Punto[];
}

export interface Punto {
    via: Via;
}

export interface Via {
    idvia:           number;
    nombre:          string;
    limitevelocidad: number;
    geom:            Geom;
    idtipovia:       Idtipovia;
    length:          number;
}

export interface Geom {
    type:        Type;
    coordinates: Array<Array<number[]>>;
}

export interface Idtipovia {
    idtipovia:   number;
    descripcion: string;
}







