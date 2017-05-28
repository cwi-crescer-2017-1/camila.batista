﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Chat.Models
{
    public class Mensagem
    {
        public string Texto { get; set; }

        public DateTime Data { get; set; }

        public Usuario Usuario { get; set; }
    }
}