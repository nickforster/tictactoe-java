public class Bot {
    int zuSpielen = 0;
    int gespielt = 0;
    int erstZug;
    int zweitZug;

    public int botSpielen(int[][] spielfeld) {
        switch (gespielt) {
            case 0:
                zuSpielen = zug1(spielfeld);
                break;
            case 1:
                zuSpielen = zug2(spielfeld);
                break;
            case 2:
                zuSpielen = zug3(spielfeld);
                break;
            case 3:
                zuSpielen = zug4(spielfeld);
                break;
        }
        return zuSpielen;
    }

    public int zug1(int[][] spielfeld) {
        if (spielfeld[0][0] > 0) {
            zuSpielen = 5;
            erstZug = 1;
        } else if (spielfeld[0][1] > 0) {
            zuSpielen = 5;
            erstZug = 2;
        } else if (spielfeld[0][2] > 0) {
            zuSpielen = 5;
            erstZug = 3;
        } else if (spielfeld[1][0] > 0) {
            zuSpielen = 5;
            erstZug = 4;
        } else if (spielfeld[1][1] > 0) {
            zuSpielen = 1;
            erstZug = 5;
        } else if (spielfeld[1][2] > 0) {
            zuSpielen = 5;
            erstZug = 6;
        } else if (spielfeld[2][0] > 0) {
            zuSpielen = 5;
            erstZug = 7;
        } else if (spielfeld[2][1] > 0) {
            zuSpielen = 5;
            erstZug = 8;
        } else if (spielfeld[2][2] > 0) {
            zuSpielen = 5;
            erstZug = 9;
        }
        gespielt++;

        return zuSpielen;
    }

    public int zug2(int[][] spielfeld) {
        zuSpielen = 0;
        moeglicherSieg(spielfeld);

        if (zuSpielen == 0) {
            moeglicheNiederlage(spielfeld);
        }

        if (zuSpielen == 0) {
            if (erstZug == 1) {
                if (spielfeld[1][2] == 2) {
                    zuSpielen = 2;
                    zweitZug = 6;
                    //rest automatisch
                } else if (spielfeld[2][1] == 2) {
                    zuSpielen = 6;
                    zweitZug = 8;
                    //rest automatisch
                } else if (spielfeld[2][2] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 2;
                    zweitZug = 9;
                    //rest automatisch
                }
            } else if (erstZug == 2) {
                if (spielfeld[1][0] == 2) {
                    zuSpielen = 7;
                    zweitZug = 4;
                    //rest automatisch
                } else if (spielfeld[2][0] == 2) {
                    zuSpielen = 6;
                    zweitZug = 7;
                    //rest automatisch
                } else if (spielfeld[2][1] == 2) {
                    zuSpielen = 1;
                    zweitZug = 8;
                    //rest automatisch
                } else if (spielfeld[2][2] == 2) {
                    zuSpielen = 6;
                    zweitZug = 9;
                    //rest automatisch
                } else if (spielfeld[1][2] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 1;
                    zweitZug = 6;
                    //rest automatisch
                }
            } else if (erstZug == 3) {
                if (spielfeld[2][1] == 2) {
                    zuSpielen = 6;
                    zweitZug = 8;
                    //rest automatisch
                } else if (spielfeld[1][0] == 2) {
                    zuSpielen = 8;
                    zweitZug = 4;
                    //rest automatisch
                } else if (spielfeld[2][0] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 6;
                    zweitZug = 7;
                    //rest automatisch
                }
            } else if (erstZug == 4) {
                if (spielfeld[2][1] == 2) {
                    zuSpielen = 9;
                    zweitZug = 8;
                    //rest automatisch
                } else if (spielfeld[2][2] == 2) {
                    zuSpielen = 2;
                    zweitZug = 9;
                    //rest automatisch
                } else if (spielfeld[1][2] == 2) {
                    zuSpielen = 7;
                    zweitZug = 6;
                    //rest automatisch
                } else if (spielfeld[0][2] == 2) {
                    zuSpielen = 2;
                    zweitZug = 3;
                    //rest automatisch
                } else if (spielfeld[0][1] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 7;
                    zweitZug = 2;
                    //rest automatisch
                }
            } else if (erstZug == 5) {
                zuSpielen = 3;
                zweitZug = 9;
                //1. nächster Zug automatisch, danach automatisch oder 4
            } else if (erstZug == 6) {
                if (spielfeld[0][1] == 2) {
                    zuSpielen = 1;
                    zweitZug = 2;
                    //rest automatisch
                } else if (spielfeld[0][0] == 2) {
                    zuSpielen = 8;
                    zweitZug = 1;
                    //rest automatisch
                } else if (spielfeld[1][0] == 2) {
                    zuSpielen = 3;
                    zweitZug = 4;
                    //rest automatisch
                } else if (spielfeld[2][0] == 2) {
                    zuSpielen = 8;
                    zweitZug = 7;
                    //rest automatisch
                } else if (spielfeld[2][1] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 3;
                    zweitZug = 8;
                    //rest automatisch
                }
            } else if (erstZug == 7) {
                if (spielfeld[0][1] == 2) {
                    zuSpielen = 4;
                    zweitZug = 2;
                    //rest automatisch
                } else if (spielfeld[1][2] == 2) {
                    zuSpielen = 2;
                    zweitZug = 6;
                    //rest automatisch
                } else if (spielfeld[0][2] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 4;
                    zweitZug = 3;
                    //rest automatisch
                }
            } else if (erstZug == 8) {
                if (spielfeld[1][2] == 2) {
                    zuSpielen = 3;
                    zweitZug = 6;
                    //rest automatisch
                } else if (spielfeld[0][2] == 2) {
                    zuSpielen = 4;
                    zweitZug = 3;
                    //rest automatisch
                } else if (spielfeld[0][1] == 2) {
                    zuSpielen = 9;
                    zweitZug = 2;
                    //rest automatisch
                } else if (spielfeld[0][0] == 2) {
                    zuSpielen = 4;
                    zweitZug = 1;
                    //rest automatisch
                } else if (spielfeld[1][0] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 9;
                    zweitZug = 4;
                    //rest automatisch
                }
            } else if (erstZug == 9) {
                if (spielfeld[1][0] == 2) {
                    zuSpielen = 8;
                    zweitZug = 4;
                    //rest automatisch
                } else if (spielfeld[0][1] == 2) {
                    zuSpielen = 4;
                    zweitZug = 2;
                    //rest automatisch
                } else if (spielfeld[0][0] == 2) { //if statement kann eventuell auch weggelassen werden
                    zuSpielen = 8;
                    zweitZug = 1;
                    //rest automatisch
                }
            }
        }
        gespielt++;

        return zuSpielen;
    }

    public int zug3(int[][] spielfeld) {
        zuSpielen = 0;

        moeglicherSieg(spielfeld);

        if (zuSpielen == 0) {
            moeglicheNiederlage(spielfeld);
        }

        if (zuSpielen == 0) {
            if (erstZug == 1) {
                if (spielfeld[0][2] == 2) {
                    if (spielfeld[2][1] == 2) {
                        zuSpielen = 4;
                    }
                } else if (spielfeld[2][0] == 2) {
                    if (spielfeld[1][2] == 2) {
                        zuSpielen = 2;
                    }
                }
            } else if (erstZug == 3) {
                if (spielfeld[2][2] == 2) {
                    if (spielfeld[1][0] == 2) {
                        zuSpielen = 2;
                    }
                } else if (spielfeld[0][0] == 2) {
                    if (spielfeld[2][1] == 2) {
                        zuSpielen = 6;
                    }
                }
            } else if (erstZug == 5) {
                if (spielfeld[0][1] == 2) {
                    if (spielfeld[2][2] == 2) {
                        zuSpielen = 7;
                    }
                } else if (spielfeld[1][0] == 2) {
                    if (spielfeld[2][2] == 2) {
                        zuSpielen = 2;
                    }
                }
            } else if (erstZug == 7) {
                if (spielfeld[0][0] == 2) {
                    if (spielfeld[1][2] == 2) {
                        zuSpielen = 8;
                    }
                } else if (spielfeld[2][2] == 2) {
                    if (spielfeld[2][1] == 2) {
                        zuSpielen = 4;
                    }
                }
            } else if (erstZug == 9) {//if statement kann eventuell weggelassen werden
                if (spielfeld[2][0] == 2) {
                    if (spielfeld[0][1] == 2) {
                        zuSpielen = 6;
                    }
                } else if (spielfeld[0][2] == 2) {
                    if (spielfeld[1][2] == 2) {
                        zuSpielen = 8;
                    }
                }
            }
        }
        if (zuSpielen == 0) {
            zuSpielen = 7;
        }
        
        gespielt++;

        return zuSpielen;
    }

    public int zug4(int[][] spielfeld) {
        zuSpielen = 0;

        moeglicherSieg(spielfeld);

        if (zuSpielen == 0) {
            moeglicheNiederlage(spielfeld);
        }

        if (zuSpielen == 0) {
            if (erstZug == 1) {
                if (spielfeld[0][1] == 2 && spielfeld[2][0] == 2 && spielfeld[1][2] == 2) {
                    zuSpielen = 8;
                } else if (spielfeld[1][0] == 2 && spielfeld[0][2] == 2 && spielfeld[2][1] == 2) {
                    zuSpielen = 6;
                }
            } else if (erstZug == 2) {
                if (spielfeld[0][0] == 2 && spielfeld[2][0] == 2 && spielfeld[1][2] == 2) {
                    zuSpielen = 8;
                } else if (spielfeld[0][2] == 2 && spielfeld[2][2] == 2 && spielfeld[1][0] == 2) {
                    zuSpielen = 8;
                }
            } else if (erstZug == 3) {
                if (spielfeld[1][2] == 2 && spielfeld[0][0] == 2 && spielfeld[2][1] == 2) {
                    zuSpielen = 4;
                } else if (spielfeld[0][1] == 2 && spielfeld[2][2] == 2 && spielfeld[1][0] == 2) {
                    zuSpielen = 8;
                }
            } else if (erstZug == 4) {
                if (spielfeld[2][0] == 2 && spielfeld[2][2] == 2 && spielfeld[0][1] == 2) {
                    zuSpielen = 6;
                } else if (spielfeld[0][0] == 2 && spielfeld[0][2] == 2 && spielfeld[2][1] == 2) {
                    zuSpielen = 6;
                }
            } else if (erstZug == 5) {
                if (spielfeld[0][1] == 2 && spielfeld[1][0] == 2 && spielfeld[2][2] == 2) {
                    zuSpielen = 3;
                } else if (spielfeld[0][2] == 2 && spielfeld[1][0] == 2 && spielfeld[2][2] == 2) {
                    zuSpielen = 2;
                }
            } else if (erstZug == 6) {
                if (spielfeld[0][2] == 2 && spielfeld[0][0] == 2 && spielfeld[2][1] == 2) {
                    zuSpielen = 4;
                } else if (spielfeld[2][2] == 2 && spielfeld[2][0] == 2 && spielfeld[0][1] == 2) {
                    zuSpielen = 4;
                }
            } else if (erstZug == 7) {
                if (spielfeld[1][0] == 2 && spielfeld[2][2] == 2 && spielfeld[0][1] == 2) {
                    zuSpielen = 6;
                } else if (spielfeld[2][1] == 2 && spielfeld[0][0] == 2 && spielfeld[1][2] == 2) {
                    zuSpielen = 4;
                }
            } else if (erstZug == 8) {
                if (spielfeld[2][2] == 2 && spielfeld[0][2] == 2 && spielfeld[1][0] == 2) {
                    zuSpielen = 2;
                } else if (spielfeld[2][0] == 2 && spielfeld[0][0] == 2 && spielfeld[1][2] == 2) {
                    zuSpielen = 2;
                }
            } else if (erstZug == 9) {
                if (spielfeld[2][1] == 2 && spielfeld[0][2] == 2 && spielfeld[1][0] == 2) {
                    zuSpielen = 2;
                } else if (spielfeld[1][2] == 2 && spielfeld[2][0] == 2 && spielfeld[0][1] == 2) {
                    zuSpielen = 4;
                }
            }

        }

        if (zuSpielen == 0) {
            zuSpielen = 4;
        }
        gespielt++;

        return zuSpielen;
    }

    public void moeglicheNiederlage(int[][] spielfeld) {
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 2 && spielfeld[i][1] == 2 && spielfeld[i][2] == 0) {
                zuSpielen = (i + 1) * 3;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 2 && spielfeld[i][1] == 0 && spielfeld[i][2] == 2) {
                zuSpielen = (i + 1) * 3 - 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 0 && spielfeld[i][1] == 2 && spielfeld[i][2] == 2) {
                zuSpielen = i * 3 + 1;//(i+1)*3-2
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 0 && spielfeld[1][i] == 2 && spielfeld[2][i] == 2) {
                zuSpielen = i + 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 2 && spielfeld[1][i] == 0 && spielfeld[2][i] == 2) {
                zuSpielen = i + 4;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 2 && spielfeld[1][i] == 2 && spielfeld[2][i] == 0) {
                zuSpielen = i + 7;
            }
        }
        //Mitte muss nicht getestet werden weil die Mitte immer Besetzt ist.

        if (spielfeld[0][0] == 2 && spielfeld[1][1] == 2 && spielfeld[2][2] == 0) {
            zuSpielen = 9;
        } else if (spielfeld[0][0] == 0 && spielfeld[1][1] == 2 && spielfeld[2][2] == 2) {
            zuSpielen = 1;
        } else if (spielfeld[0][2] == 2 && spielfeld[1][1] == 2 && spielfeld[2][0] == 0) {
            zuSpielen = 7;
        } else if (spielfeld[0][2] == 0 && spielfeld[1][1] == 2 && spielfeld[2][0] == 2) {
            zuSpielen = 3;
        }
    }

    public void moeglicherSieg(int[][] spielfeld) {
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 1 && spielfeld[i][1] == 1 && spielfeld[i][2] == 0) {
                zuSpielen = (i + 1) * 3;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 1 && spielfeld[i][1] == 0 && spielfeld[i][2] == 1) {
                zuSpielen = (i + 1) * 3 - 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == 0 && spielfeld[i][1] == 1 && spielfeld[i][2] == 1) {
                zuSpielen = i * 3 + 1;//(i+1)*3-2
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 0 && spielfeld[1][i] == 1 && spielfeld[2][i] == 1) {
                zuSpielen = i + 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 1 && spielfeld[1][i] == 0 && spielfeld[2][i] == 1) {
                zuSpielen = i + 4;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == 1 && spielfeld[1][i] == 1 && spielfeld[2][i] == 0) {
                zuSpielen = i + 7;
            }
        }
        //Mitte muss nicht getestet werden weil die Mitte immer Besetzt ist.

        if (spielfeld[0][0] == 1 && spielfeld[1][1] == 1 && spielfeld[2][2] == 0) {
            zuSpielen = 9;
        } else if (spielfeld[0][0] == 0 && spielfeld[1][1] == 1 && spielfeld[2][2] == 1) {
            zuSpielen = 1;
        } else if (spielfeld[0][2] == 1 && spielfeld[1][1] == 1 && spielfeld[2][0] == 0) {
            zuSpielen = 7;
        } else if (spielfeld[0][2] == 0 && spielfeld[1][1] == 1 && spielfeld[2][0] == 1) {
            zuSpielen = 3;
        }
    }
}